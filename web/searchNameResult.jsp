<%-- 
    Document   : myPost
    Created on : Oct 26, 2019, 1:46:52 PM
    Author     : hongq
--%>

<%@page import="dal.UserDAO"%>
<%@page import="until.SessionHelper"%>
<%@page import="models.Topic"%>
<%@page import="dal.TopicDAO"%>
<%@page import="models.Photo"%>
<%@page import="dal.PhotoDAO"%>
<%@page import="dal.CommentDAO"%>
<%@page import="models.Comment"%>
<%@page import="models.Poster"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dal.PosterDAO"%>
<%@page import="models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            CommentDAO commentDAO = new CommentDAO();
            PhotoDAO photoDAO = new PhotoDAO();
            UserDAO userDAO = new UserDAO();
            TopicDAO topicDAO = new TopicDAO();
            PosterDAO posterDAO = new PosterDAO();
            String searchedText = (String) request.getAttribute("searchText");
            User userInstance = SessionHelper.getUserFromSession(session);
            ArrayList<Poster> listPosterNameSearched = posterDAO.searchByPosterName(searchedText);
            Photo userPhotoInstance = photoDAO.getPhotoByUserID(userInstance.getID());
            ArrayList<String> listTopicID = topicDAO.getListTopicIDByDESC();
        %>
        <title>Topics of books</title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,700" rel="stylesheet">

        <link rel="stylesheet" href="Profile/css/open-iconic-bootstrap.min.css">
        <link rel="stylesheet" href="Profile/css/animate.css">

        <link rel="stylesheet" href="Profile/css/owl.carousel.min.css">
        <link rel="stylesheet" href="Profile/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="Profile/css/magnific-popup.css">

        <link rel="stylesheet" href="Profile/css/aos.css">

        <link rel="stylesheet" href="Profile/css/ionicons.min.css">

        <link rel="stylesheet" href="Profile/css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="Profile/css/jquery.timepicker.css">


        <link rel="stylesheet" href="Profile/css/flaticon.css">
        <link rel="stylesheet" href="Profile/css/icomoon.css">
        <link rel="stylesheet" href="Profile/css/style.css">

        <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700|Playfair+Display:400,700,900" rel="stylesheet">

        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/search.css">
    </head>
    <body>

        <div class="site-mobile-menu">
            <div class="site-mobile-menu-header">
                <div class="site-mobile-menu-close mt-3">
                    <span class="icon-close2 js-menu-toggle"></span>
                </div>
            </div>
            <div class="site-mobile-menu-body"></div>
        </div>

        <header class="site-navbar" role="banner">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <!-- LOGO--------------------------------------------------------------------------------------------- -->
                    <div class="col-5 site-logo">
                        <a href="list" class="text-black h2 mb-0">Bookworm</a>
                    </div>
                    <div class="container1">
                        <form action="searchNameResult" method="get">
                            <input type="text"  name="searchText" placeholder="Search...">
                            <div class="search1"></div>
                            <input type="submit" style="position: absolute; left: -9999px"/>
                        </form>
                    </div>
                    <!-- Option--------------------------------------------------------------------------------------------- -->
                    <div class="col-7 text-center">
                        <nav class="site-navigation" role="navigation">
                            <ul class="site-menu js-clone-nav mr-auto d-none d-lg-block mb-0">
                                <li><a href="list">Home</a></li>
                                <a href="aboutMe?uid=<%=userInstance.getID()%>"><img  src="images/<%=userPhotoInstance.getPhotoname()%>" alt="" width="42" height="42"/> </a>
                                <li><a href="aboutMe?uid=<%=userInstance.getID()%>"> <%=userInstance.getDisplayname()%> </a></li>

                                <li><a href="logout"> Logout </a></li>
                                <div class="col-12 search-form-wrap js-search-form">
                                    <form method="get" action="#">
                                        <button class="search-btn" type="submit"><span class="icon-search"></span></button>
                                        <input type="text" id="s" class="form-control" placeholder="Search...">
                                    </form>
                                </div>
                                <li class="d-none d-lg-inline-block"><a href="#" class="js-search-toggle"><span
                                            class="icon-search"></span></a></li>
                            </ul>
                        </nav>
                        <a href="#" class="site-menu-toggle js-menu-toggle text-black d-inline-block d-lg-none"><span
                                class="icon-menu h3"></span></a>
                    </div>
                </div>
            </div>
        </header>

        <div id="colorlib-page">
            <a href="list" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
            <aside id="colorlib-aside" role="complementary" class="js-fullheight text-center">
                <br> <br><h1 id="colorlib-logo"><a>Topics<span>.</span></a></h1>
                <nav id="colorlib-main-menu" role="navigation">
                    <ul>
                        <li class="colorlib-active"><a href="searchNameResult?searchText=<%=searchedText%>">Post name</a></li>
                        <li class="colorlib-active"><a href="searchScriptResult?searchText=<%=searchedText%>">Posts substance</a></li>
                        <li class="colorlib-active"><a href="listPostsByTopic?tid=t1">Topic >> </a></li>
                    </ul>
                </nav>

                <div class="colorlib-footer">
                    <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                </div>
            </aside> <!-- END COLORLIB-ASIDE -->
            <div id="colorlib-main">
                <section class="ftco-section">
                    <div class="container">
                        <div class="row justify-content-center mb-5 pb-2">
                            <div class="col-md-7 heading-section text-center ftco-animate">
                                <h2 class="mb-4">  Posts have Name contains "<%=searchedText%>"  </h2>
                                <p>List of my posts about book I have read !</p>
                                <%
                                    if (listPosterNameSearched.size() == 0) {
                                %>
                                <h3>We don't have any poster has Name contains "<%=searchedText%>"</h3>
                                <%}%>
                            </div>
                        </div>
                        <div class="row">

                            <%
                                for (Poster p : listPosterNameSearched) {
                                    int commentCount = commentDAO.getCommentCountByPostID(p.getID());
                                    User usertopic = userDAO.getUserByPostID(p.getID());
                                    Photo photoUserOFPost = photoDAO.getPhotoByUserID(usertopic.getID());
                                    ArrayList<Topic> listTopicsOFPost = topicDAO.getTopicsByPostID(p.getID());
                            %>
                            <div class="col-md-4">
                                <div class="blog-entry ftco-animate">
                                    <a href="singlePost?poid=<%=p.getID()%>" class="img img-2" style="background-image: url(images/<%=p.getImage()%>);"></a>
                                    <div class="text text-2 pt-2 mt-3">
                                        <%
                                            for (Topic t : listTopicsOFPost) {
                                        %>
                                        <span class="category mb-3 d-block"><a><%=t.getText()%></a></span>
                                                <%}%>
                                        <h3 class="mb-4"><a href="singlePost?poid=<%= p.getID()%>"><%=p.getPostName()%></a></h3>
                                        <p class="mb-4"><%=p.getText().substring(0, 50) + "..."%></p>
                                        <div class="author mb-4 d-flex align-items-center">
                                            <a href="aboutMe?uid=<%=usertopic.getID()%>" class="img" style="background-image: url(images/<%=photoUserOFPost.getPhotoname()%>);"></a>
                                            <div class="ml-3 info">
                                                <span>Written by</span>
                                                <h3><a href="aboutMe?uid=<%=usertopic.getID()%>"><%=usertopic.getDisplayname()%></a>, <span><%=p.getPostingDate()%></span></h3>
                                            </div>
                                        </div>
                                        <div class="meta-wrap align-items-center">
                                            <div class="half order-md-last">
                                                <p class="meta">
                                                    <span><i class="icon-comment"><%=commentCount%></i></span>
                                                </p>
                                            </div>
                                            <div class="half">
                                                <p><a href="singlePost?poid=<%=p.getID()%>" class="btn py-2">Continue Reading<span class="ion-ios-arrow-forward"></span></a></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%}%>

                        </div>
                    </div>
                </section>
                <footer class="ftco-footer ftco-bg-dark ftco-section">
                    <div class="container px-md-5">
                        <div class="row mb-5">
                            <div class="col-md">
                                <div class="ftco-footer-widget mb-4 ml-md-4">
                                    <h2 class="ftco-heading-2">Category</h2>
                                    <ul class="list-unstyled categories">
                                        <%
                                            int j = 0;
                                            for (int k = listTopicID.size() - 1; k >= 0; k--) {
                                                Topic topic1 = topicDAO.getTopicbyTopicID(listTopicID.get(k));
                                                int countPostByTopic = topicDAO.getCountPostsbyTopicID(topic1.getID());
                                                j++;
                                                if (j == 6) {
                                                    break;
                                                }
                                        %>
                                        <li><a href="listPostsByTopic?tid=<%=topic1.getID()%>"><%=topic1.getText()%> <span>(<%=countPostByTopic%>)</span></a></li>
                                            <%}%>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md">
                                <div class="ftco-footer-widget mb-4">
                                    <h2 class="ftco-heading-2">Archives</h2>
                                    <ul class="list-unstyled categories">
                                        <%
                                            int i = 0;
                                            for (String s : listTopicID) {
                                                Topic topic2 = topicDAO.getTopicbyTopicID(s);
                                                int countPostByTopic = topicDAO.getCountPostsbyTopicID(topic2.getID());
                                                i++;
                                                if (i == 6) {
                                                    break;
                                                }
                                        %>
                                        <li><a href="listPostsByTopic?tid=<%=topic2.getID()%>"><%=topic2.getText()%> <span>(<%=countPostByTopic%>)</span></a></li>
                                            <%}%>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md">
                                <div class="ftco-footer-widget mb-4">
                                    <h2 class="ftco-heading-2">Have a Questions?</h2>
                                    <div class="block-23 mb-3">
                                        <ul>
                                            <li><span class="icon icon-map-marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span></li>
                                            <li><a href="#"><span class="icon icon-phone"></span><span class="text">+2 392 3929 210</span></a></li>
                                            <li><a href="#"><span class="icon icon-envelope"></span><span class="text">quanghhhe130699@fpt.edu.vn</span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">

                                <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                            </div>
                        </div>
                    </div>
                </footer>
            </div><!-- END COLORLIB-MAIN -->
        </div><!-- END COLORLIB-PAGE -->

        <!-- loader -->
        <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

        <script src="Profile/js/jquery.min.js"></script>
        <script src="Profile/js/jquery-migrate-3.0.1.min.js"></script>
        <script src="Profile/js/popper.min.js"></script>
        <script src="Profile/js/bootstrap.min.js"></script>
        <script src="Profile/js/jquery.easing.1.3.js"></script>
        <script src="Profile/js/jquery.waypoints.min.js"></script>
        <script src="Profile/js/jquery.stellar.min.js"></script>
        <script src="Profile/js/owl.carousel.min.js"></script>
        <script src="Profile/js/jquery.magnific-popup.min.js"></script>
        <script src="Profile/js/aos.js"></script>
        <script src="Profile/js/jquery.animateNumber.min.js"></script>
        <script src="Profile/js/bootstrap-datepicker.js"></script>
        <script src="Profile/js/jquery.timepicker.min.js"></script>
        <script src="Profile/js/scrollax.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="Profile/js/google-map.js"></script>
        <script src="Profile/js/main.js"></script>


        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/jquery.countdown.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/bootstrap-datepicker.min.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
