package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/text")
	public String showText() {
		return "<html>"
				+ "<head>"
				+ "ISI_LANGUAGE"
				+ "</head>"
				+ "<body>"
				+ "<form method='get' action='IsiServlet'>"
				+ "FILE:<input name='file' type='file' id='file' accept='text/plain' onchange='openFile(event)'> <br>"
				+ "texto:<input name='text' type='text' id='text'> <br>"
				+ "IsiLanguage:<pre name='isiText' id='output'></pre>"
				+ "Other:<pre name='otherLang' id='output2'></pre>"
				+ "</form>"
				+ "<script>"
				+ "var openFile = function (event) {"
				+ "		var input = event.target;"
				+ "		var reader = new FileReader();"
				+ "		reader.onload = function() {"
				+ "			var text = reader.result;"
				+ "			var node = document.getElementById('output');"
				+ "			node.innerHTML = text;"
				+ "		};"
				+ "		reader.readAsText(input.files[0]);"
				+ "};"
				+ "</script>"
				+ "</body>"
				+ "</html>";
	}
}
