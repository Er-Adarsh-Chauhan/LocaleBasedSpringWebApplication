<!-- 
*************************************************************************************************************
*	Created By		:		Adarsh Chauhan.   																*
*	Created Date	: 		30-July-2019      																*
*	Last Modified 	:		09-Aug-2019       																*
*   Description		:		Shows Locale Based Date and Time for Two different Zones with GMT,Currency  and	*
*							Number Formats and Phone Number Representation. And Also Locale Based Language  *
*							Change.																			*
*************************************************************************************************************
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home Page</title>
</head>
<body>
		 <strong>Language</strong> : <a href="?locale=en&code=US">English</a> | <a href="?locale=hi&code=IN">Hindi</a> | 
									 <a href="?locale=fr&code=FR">French</a> | <a href="?locale=zh&code=SG">Chinese(Singapore)</a>
									
									 <div style="margin-left:100px;margin-right:100px;margin-top:20px;font-size:0.8em;font-family: Verdana;">
									 		 ${currentCountry} <br/>${finalCountry}
									 </div>
									 <div style="margin-left:600px;margin-right:10px;margin-top:-70px;font-size:0.8em;font-family: Verdana;">
									 		<p style="margin-left:100px;margin-right:100px"><strong><u>Time With GMT</u></strong></p>
									 		${str3}<br/>${str4}
									 </div>
									 <div style="text-align:center;;margin-top:30px;font-size:0.8em;font-family: Verdana;">
									 		<p style="margin-left:100px;margin-right:100px"><strong><u>Currency and Number Representation</u></strong></p>
									 		${currency}  &nbsp;&nbsp;&nbsp;&nbsp;
									 	
									 		${number}
									 </div>
									 <div style="text-align:center;;margin-top:30px;font-size:0.8em;font-family: Verdana;">
									 		<p style="margin-left:100px;margin-right:100px"><strong><u>Phone Number Formats for Country</u></strong></p>
									 			${PhoneNumber}
									 </div>
									 
		<br/><br/>
		
				${str1} <br/>
				${str2}
				
				
				
				
				
				
				
</body>
</html>
