
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header class="header-section">
    <nav class="navbar navbar-default">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/"><b>M</b>art</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/dress/dressList">옷</a></li>
                    <li><a href="${pageContext.request.contextPath}/board/boardList">고객센터</a></li>
                    <li><a href="${pageContext.request.contextPath}/grid/index">grid</a></li>
                    <li><a href="#">과일</a></li>

                    <li><a href="#">Contact Us</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right cart-menu">
                    <li><a href="#" class="search-btn"><i class="fa fa-search" aria-hidden="true"></i></a></li>
                    <li><a href="#"><span> Cart -$0&nbsp;</span> <span class="shoping-cart">0</span></a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>