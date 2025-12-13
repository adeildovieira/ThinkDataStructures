package com.allendowney.thinkdast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
		new HelloJsoup().createDocument();
//		}
//
	private void createDocument() throws IOException {
		String dirname = System.getProperty("user.dir");
		String filename = "src/resources/en.wikipedia.org/wiki/Computer_science";
		String baseURI = dirname + "/" + filename;

		File input = new File(baseURI);
		Document doc = Jsoup.parse(input, "UTF-8", baseURI);

		Element content = doc.getElementById("mw-content-text");
		if (content == null) {
			print("Content not found in %s", filename);
			return;
		}

		Elements paragraphs = content.getElementsByTag("p");
		for (Element p : paragraphs) {
			Elements links = p.select("a[href]");
			for (Element link : links) {
				print(" * a: <%s>  (%s)", link.attr("href"), trim(link.text(), 35));
			}
			// only display the first paragraph's links
			break;
		}
//		}
//
//		print("\nLinks: (%d)", links.size());
//		for (Element link : links) {
//			print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
//			break;
//		}
	}

	private void createDocument() {
		// TODO Auto-generated method stub
		
	}

	private static void print(String msg, Object... args) {
		System.out.println(String.format(msg, args));
	}

	private static String trim(String s, int width) {
		if (s.length() > width)
			return s.substring(0, width-1) + ".";
		else
			return s;
	}
}
