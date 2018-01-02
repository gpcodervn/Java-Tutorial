package com.gpcoder.enumdemo;

public enum Color {

	RED("red") {
		@Override
		public String getHexCode() {
			return "#ff0000";
		}
	},
	GREEN("green") {
		@Override
		public String getHexCode() {
			return "#00ff00";
		}
	},
	BLUE("blue") {
		@Override
		public String getHexCode() {
			return "#0000ff";
		}
	};

	private String name;

	Color(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract String getHexCode();

}