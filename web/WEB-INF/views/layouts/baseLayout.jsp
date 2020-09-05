<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<script type="text/javascript" src="/resources/js/vendor/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="/resources/js/vendor/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/js/isotope.pkgd.min.js"></script>
<script type="text/javascript" src="/resources/js/owl.carousel.min.js"></script>
<script type="text/javascript" src="/resources/js/wow.min.js"></script>
<script type="text/javascript" src="/resources/js/custom.js"></script>
<link rel="stylesheet" href="/resources/css/style.css">


<html>
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>younghee shop</title>


</head>
<style type="text/css">
    #baseLayout-wrapper {
        min-height: 100%;
        margin: 0 auto -100px;
    }

    #baseLayout-header {
        width: 100%;
    }

    #baseLayout-navigation {
        width: 100%;
        height: 100px;
    }

    #baseLayout-container {
        width: 100%;
    }

    #baseLayout-footer {
        width: 100%;
    }

    #baseLayout-push {
        margin: 0;
        height: 100px;
    }
</style>

<body>
<div id="baseLayout-wrapper">
    <div id="baseLayout-header">
        <tiles:insertAttribute name="header"/>
    </div>
    <div id="baseLayout-navigation">
        <tiles:insertAttribute name="navigation"/>
    </div>
    <div id="baseLayout-container">
        <tiles:insertAttribute name="container"/>
    </div>
    <div id="baseLayout-push"></div>
</div>
<div id="baseLayout-footer">
    <tiles:insertAttribute name="footer"/>
</div>
</body>

</html>


