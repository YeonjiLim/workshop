package com.ssafy.edu.java2;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.swing.text.html.parser.DocumentParser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherDAO2 {
	List<Weather> list = new ArrayList<>();

	public List<Weather> getNewsList(String url) {
		list.removeAll(list);
		connectWeather(url);
		return list;

	}

	private List<Weather> connectWeather(String url) {
		SAXParserFactory f = SAXParserFactory.newInstance();
		try {
			SAXParser parser = f.newSAXParser();
			SAXHandler handler = new SAXHandler();
			parser.parse(new URL(url).openConnection().getInputStream(),
					handler);
			return list;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	
	/*
	 * Outter handler class -> Saxparser 가 호출할 것임
	 * 핸들러는 태그를 만날때 자동 call back(호출) 이 되어 실행됨
	 */
	
	//Sax의 Handler 만드는 함수. tag만들때마다 이벤트 처리해주는거 
	public class SAXHandler extends DefaultHandler {
		private StringBuilder sb;// mutable, 값 주소 다 변함. 스트링은 바뀔때마다 버리고 새로운주소에 받음
		// 마지막에 처리할때는 sb를 던지면안되고 sb.toString으로 해서 스트링형태로 보내야함
		
		// DAO가 생성되어서 NewsSaxHandler를 new하면 Item이 news를 쓸수있음. NewsSaxHandler를 하나의 데이터로 볼수있음.
		Weather w;

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			super.characters(ch, start, length);
			//ch는 char array로 들어오는건데 알아서 스트링으로 묶어준뒤 sb뒤에 append해서 문자열 만들어줌
			sb.append(ch, start, length);
		}

		@Override
		public void endElement(String uri, String localName, String name)
				throws SAXException {
			if (w != null) {
				if (name.equalsIgnoreCase("hour")) {
					w.setHour(sb.toString().trim());
				} else if (name.equalsIgnoreCase("temp")) {
					w.setTemp(sb.toString().trim());
				} else if (name.equalsIgnoreCase("wfKor")) {
					w.setWfKor(sb.toString().trim());
				} else if (name.equalsIgnoreCase("reh")) {
					w.setReh(sb.toString().trim());
				} else if (name.equalsIgnoreCase("data")) {
					list.add(w);
				}
			}
			sb.setLength(0); // 문자열제거
		}

		@Override
		public void startDocument() throws SAXException { // XML 에 접근할때 시작하는 startDocument - 지금까지있던거 청소시키고 준비하겠다.
			super.startDocument(); // super는 defaultHandler를 의미함. 
			list = new ArrayList<Weather>();// list.clear와 같은효과
			sb = new StringBuilder(); // sb.setLength(0) 해도됨
		}

		@Override
		public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
			//uri + localName => namespace, name은 꺽새안에 들어가는거 attributes 자동으로 인식함
			super.startElement(uri, localName, name, attributes);
			//node name은 대소문자 구문안하겠다는 함수
			if (name.equalsIgnoreCase("data")) {  // data라는 태그를 만나면
				w = new Weather(); // 아이템을 만들겠다.
			}
		}
	}

}