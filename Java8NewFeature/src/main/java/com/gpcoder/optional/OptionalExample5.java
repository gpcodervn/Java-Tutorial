package com.gpcoder.optional;

import java.util.Optional;

public class OptionalExample5 {

	public static void main(String[] args) {
		Optional<String> me = Optional.of("gpcoder");
        Optional<String> emptyOptional = Optional.empty();

        //Filter on Optional
        System.out.println(me.filter(g -> g.equals("GPCODER"))); //Optional.empty
        System.out.println(me.filter(g -> g.equalsIgnoreCase("gpcoder"))); //Optional[gpcoder]
        System.out.println(emptyOptional.filter(g -> g.equalsIgnoreCase("gpcoder"))); //Optional.empty
	}
}
