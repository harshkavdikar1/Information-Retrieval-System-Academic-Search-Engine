<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- reference : By Kevin McGowan (https://codepen.io/BFD71/pen/rLoEdO) -->
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
  <title>Research Paper Search Engine</title>
  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <style>
  body {
  font-family: Helvetica Neue, Helvetica, Arimo, Liberation Sans, Lucida Grande, sans-serif;
  background: url("https://upload.wikimedia.org/wikipedia/en/thumb/8/80/Wikipedia-logo-v2.svg/1122px-Wikipedia-logo-v2.svg.png") no-repeat center center fixed;
	}
	
	h1,
	h2,
	h3,
	h4 {
	  font-family: Times, Georgia, Linux Libertine, Cambria, serif;
	}
	
	h4 a,
	.list-inline li a {
	  color: white !important;
	  text-decoration: underline !important;
	}
	
	a:hover,
	a:visited,
	a:active,
	a:link {
	  text-decoration: none;
	  color: #333;
	}
	
	.pageTitle,
	.titleNote {
	  background-color: rgba(12, 33, 38, 0.5);
	  color: white;
	}
	
	.search_box,
	.searchSubmit,
	#randomPage {
	  height: 4rem;
	  min-height: 1.2em;
	  line-height: 1.6rem;
	  verticle-align: middle;
	  display: inline-block;
	  margin: 2.2rem auto 1.5em;
	  padding: .5rem 1rem;
	}
	
	.search_box {
	  font-size: 2rem;
	  width: 400px;
	  background: #fff;
	  border: .5px solid #ccc;
	  box-shadow: inset 0 0 0 .1em #ccc;
	  border-radius: .1em;
	}
	
	.searchSubmit,
	#randomPage {
	  font-weight: 70;
	  color: #fff;
	  cursor: pointer;
	  background-color: #165c91;
	  border: 1px solid #165c91;
	  text-align: center;
	}
	
	#randomPage a {
	  color: #fff;
	}
	/* RESULTS */
	
	.resultDisplay {
	  
	}
	
	.results {
	  font-size: 2rem;
	  max-width: 800px;
	  background: #fff;
	  border: .5px solid #ccc;
	  box-shadow: inset 0 0 0 .1em #ccc;
	  border-radius: .1em;
	  padding: 1rem;
	  margin: .2rem;
	}
	
	
	.extract {
	  font-size: 12px;
	}
	

	* {
	  margin: 0;
	}
	
	html,
	body {
	  height: 100%;
	}
	
	.wrapper {
	  min-height: 100%; 
	  height: auto !important; /*Cause footer to stick to bottom in IE 6*/
	  height: 100%; 
	  margin: 0 auto -4em; /*Allow for footer height*/
	
	}
	
	.footer,
	.push {
	  clear: both;
	}
	
	.footer {
	  min-height: 4em;
	  background-color: rgba(12, 33, 38, 0.5);
	}
	
	.footer-menu-divider,
	.copyright {
	  color: white;
	}
	
	em {
	  color: Red;
	}
	stat{
	  color:Red;
	  background-color:white;
	}
	
	.ui-autocomplete-loading {
	    background: white url("images/ui-anim_basic_16x16.gif") right center no-repeat;
	  }
  </style>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script type="text/javascript">
	$(function() {
		$("#content").autocomplete({
			source: "researchPapersAutocomplete", 
			minLength: 3,
		});
	});
   </script>

</head>
<body>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.2/css/bootstrap.css" >
<div class="container-fluid wrapper">
  <div class="row pageTitle">
    <div class="col-md-4 col-md-offset-4 title text-center">
      <h1>Research Paper Viewer</h1>
    </div>
  </div>
  <div class="row form-group">
    <div class="col-md-8 col-md-offset-2  text-center">
		<form action="search" method="post">
			<input id="content" type="text" class="search_box" name="content" value=${content}>
			<button type="submit" class="btn btn-default" id="searchSubmit">
				<i class="fa fa-search" aria-hidden="true"></i>
			</button>
		</form>
	<c:if test = "${numberofmatches!=null}">
    <stat>About ${numberofmatches} results found in ${responsetime} milliseconds</stat>
    </c:if>
    </div>
  </div>
  <div id="display-result" class="col-md-6 col-md-offset-3 ">
	<c:forEach items="${result}" var="value" varStatus="status">
		<div id='result' class='results'><h3>${file[status.index]}</h3><p class='extract'>${value}</p></div>
	</c:forEach>
  </div>
  <div class="push"></div>
</div>
</body>
</html>

