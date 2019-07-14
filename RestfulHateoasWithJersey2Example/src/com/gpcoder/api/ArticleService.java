package com.gpcoder.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.gpcoder.model.Article;

// URI:
// http(s)://<domain>:(port)/<YourApplicationName>/<UrlPattern in web.xml>/<path>
// http://localhost:8080/RestfulWebServiceExample/rest/articles
@Path("/articles")
@PermitAll
public class ArticleService {
	
	@GET
	@Path("/")
	public Response getArticles(@Context UriInfo uriInfo) {
		List<Article> articles = Arrays.asList(
			createArticle(1),
			createArticle(2),
			createArticle(3)
		);
		
		for (Article article : articles) {
			Link selfLink = Link.fromUri(uriInfo.getAbsolutePath().resolve(article.getId().toString())).rel("self").type("GET").build();
			article.setSelf(selfLink);
		}
		
		// http://localhost:8080/RestfulWebServiceExample/rest/articles
		Link selfLink = Link.fromUri(uriInfo.getAbsolutePath()).rel("self").type("GET").build();
		
		// http://localhost:8080/RestfulWebServiceExample/rest/articles?page=2
		Link nextLink = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()
				.queryParam("page", "2"))
				.rel("next")
				.type("GET")
				.build();
		
		// http://localhost:8080/RestfulWebServiceExample/rest/articles?page=0
		Link prevLink = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()
				.queryParam("page", "0"))
				.rel("prev")
				.type("GET")
				.build();
		
		return Response.ok(articles).links(selfLink, nextLink, prevLink).build();
	}

	@GET
	@Path("/{id}")
	public Response getArticle(@PathParam("id") int id, @Context UriInfo uriInfo) {
		Article article = createArticle(id);

		// http://localhost:8080/RestfulWebServiceExample/rest/articles/1
		Link selfLink = Link.fromUri(uriInfo.getAbsolutePath().resolve(article.getId().toString())).rel("self").type("GET").build();
		
		// http://localhost:8080/RestfulWebServiceExample/rest/articles/1/comments
		Link commentLink = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()
				.path(article.getId().toString()).path("comments"))
				.rel("comments")
				.type("GET").build();
		
		// http://localhost:8080/RestfulWebServiceExample/rest/articles/1/tags
		Link tagLink = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()
				.path(article.getId().toString()).path("tags"))
				.rel("tags")
				.type("GET").build();
		
		article.setSelf(selfLink);
		return Response.ok(article).links(selfLink, commentLink, tagLink).build();
	}
	
	private Article createArticle(Integer id) {
		Article article = new Article();
		article.setId(id);
		article.setContent("HATEOAS example by gpcoder");
		article.setPublishedDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		article.setAuthorId(1);
		return article;
	}
	
	@GET
	@Path("?page={page}")
	public Response getArticles(@QueryParam("page") int page) {
		return null;
	}
	
	@GET
	@Path("/{id}/comments")
	public Response getComments(@PathParam("id") int id) {
		return null;
	}
	
	@GET
	@Path("/{id}/tags")
	public Response getTags(@PathParam("id") int id) {
		return null;
	}
}
