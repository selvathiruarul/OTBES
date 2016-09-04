<%@ page import="com.otbes.language.*,java.util.Locale,java.util.ResourceBundle"%>	
	<%
	String languageDefault = null;
	languageDefault = (String)session.getAttribute("lang");
	Locale languageCode;
	ResourceBundle resourceBundle;
	if (languageDefault != null) {
		languageCode = new Locale(languageDefault);
		resourceBundle = ResourceBundle.getBundle("com.otbes.language.resources", languageCode);
	} else {
		languageCode = new Locale("en");
		resourceBundle = ResourceBundle.getBundle("com.otbes.language.resources", languageCode);
	}
%>	