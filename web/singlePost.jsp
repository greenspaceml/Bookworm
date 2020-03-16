<%-- 
    Document   : singlePost
    Created on : Oct 26, 2019, 9:39:43 AM
    Author     : hongq
--%>

<%@page import="models.Comment"%>
<%@page import="dal.CommentDAO"%>
<%@page import="dal.UserDAO"%>
<%@page import="models.Topic"%>
<%@page import="dal.TopicDAO"%>
<%@page import="models.Photo"%>
<%@page import="dal.PhotoDAO"%>
<%@page import="models.Poster"%>
<%@page import="java.util.ArrayList"%>
<%@page import="until.SessionHelper"%>
<%@page import="models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        User user = SessionHelper.getUserFromSession(session);
        PhotoDAO photoDAO = new PhotoDAO();
        TopicDAO topicDAO = new TopicDAO();
        UserDAO userDAO = new UserDAO();
        CommentDAO commentDAO = new CommentDAO();
        Photo photoInstance = photoDAO.getPhotoByUserID(user.getID());
        Poster poster = (Poster) request.getAttribute("posters");
        ArrayList<Comment> listComment = commentDAO.getCommentsByPostID(poster.getID());

        ArrayList<Topic> topics = topicDAO.getTopicsByPostID(poster.getID());
        User uu = userDAO.getUserByPostID(poster.getID());
        Photo postUserPhoto = photoDAO.getPhotoByUserID(uu.getID());
        ArrayList<String> listTopicID = topicDAO.getListTopicIDByDESC();
    %>
    <head>
        <title><%=uu.getDisplayname()%> - <%=poster.getPostName()%></title>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

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

        <div class="site-wrap">

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
                        <div class="col-4 site-logo">
                            <a href="list" class="text-black h2 mb-0">Bookworm</a>
                        </div>
                        <div class="container1">
                            <form action="searchNameResult" method="get">
                                <input type="text"  name="searchText" placeholder="Search...">
                                <div class="search1"></div>
                                <input type="submit" style="position: absolute; left: -9999px"/>
                            </form>
                        </div>
                        <div class="col-8 text-right">
                            <nav class="site-navigation" role="navigation">
                                <ul class="site-menu js-clone-nav mr-auto d-none d-lg-block mb-0">
                                    <li>
                                        <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
                                            <div class="btn-group" role="group">
                                                <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    ...
                                                </button>
                                                <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                                                    <%
                                                        if (user.getID().equals(uu.getID()) || user.getID().equals(uu.getID())) {
                                                    %>
                                                    <a class="dropdown-item" href="deletePost?poid=<%=poster.getID()%>">Delete Post</a>
                                                    <%}%>
                                                    <%
                                                        if (!user.getID().equals(uu.getID())) {

                                                    %>
                                                    <a class="dropdown-item">
                                                        <div id="contact">Report</div>
                                                        <div id="contactForm">
                                                            <form action="report" method="post">
                                                                <input placeholder="Content" type="text" name="ReportName" required /><br>
                                                                <textarea placeholder="Problem" name="ReportText" required></textarea><br>
                                                                <input type="hidden" id="message" name="poid" value="<%=poster.getID()%>">
                                                                <input class="formBtn" type="submit" value="Send report" />
                                                            </form>
                                                        </div>
                                                    </a>
                                                    <%}%>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li><a href="list">Home</a></li>
                                    <a href="aboutMe?uid=<%=user.getID()%>"><img  src="images/<%=photoInstance.getPhotoname()%>" alt="" width="42" height="42"/> </a>
                                    <li><a href="aboutMe?uid=<%=user.getID()%>"> <%=user.getDisplayname()%> </a></li>

                                    <li><a href="logout"> Logout </a></li>
                                    <div class="col-12 search-form-wrap js-search-form">
                                        <form method="get" action="#">
                                            <button class="search-btn" type="submit"><span class="icon-search"></span></button>
                                            <input type="text" id="s" class="form-control" placeholder="Search...">
                                        </form>
                                    </div>
                                    <li class="d-none d-lg-inline-block"><a href="#" class="js-search-toggle"><span class="icon-search"></span></a></li>
                                </ul>
                            </nav>
                            <a href="#" class="site-menu-toggle js-menu-toggle text-black d-inline-block d-lg-none"><span class="icon-menu h3"></span></a></div>
                    </div>

                </div>
            </header>

            <%

            %>
            <div class="site-cover site-cover-sm same-height overlay single-page" style="background-image: url('images/<%=poster.getImage()%>');">
                <div class="container">
                    <div class="row same-height justify-content-center">
                        <div class="col-md-12 col-lg-10">
                            <div class="post-entry text-center">
                                <%
                                    for (Topic t : topics) {
                                %>
                                <span class="post-category text-white bg-success mb-3"><%=t.getText()%></span>
                                <%}%>
                                <h1 class="mb-4"><a href="singlePost?id=<%=poster.getID()%>"><%=poster.getPostName()%></a></h1>
                                <div class="post-meta align-items-center text-center">
                                    <a href="aboutMe?uid=<%=uu.getID()%>"> <figure class="author-figure mb-0 mr-3 d-inline-block"><img  src="images/<%=postUserPhoto.getPhotoname()%>" alt="Image" class="img-fluid"></figure> </a>
                                    <span href="aboutMe?uid=<%=uu.getID()%>" class="d-inline-block mt-1"><%=uu.getDisplayname()%></span>
                                    <span>&nbsp;-&nbsp; <%=poster.getPostingDate()%></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <section class="site-section py-lg">
                <div class="container">

                    <div class="row blog-entries element-animate">

                        <div class="col-md-12 col-lg-8 main-content">

                            <div class="post-content-body">
                                <div class="row mb-5 mt-5">
                                    <div class="col-md-12 mb-4">
                                        <img src="images/<%=poster.getImage()%>" alt="Image placeholder" class="img-fluid rounded">
                                    </div>
                                </div>
                                <p><%=poster.getText()%></p>
                            </div>
                            <div class="pt-5">
                                <h3 class="mb-5"><%=commentDAO.getCommentCountByPostID(poster.getID())%> <%=(commentDAO.getCommentCountByPostID(poster.getID()) <= 1) ? "Comment" : "Comments"%></h3>
                                <%
                                    for (Comment c : listComment) {

                                        User uc = userDAO.getUserByCommentID(c.getID());
                                        Photo photoc = photoDAO.getPhotoByUserID(uc.getID());
                                %>
                                <ul class="comment-list">
                                    <li class="comment">
                                        <div class="vcard">
                                            <a href="aboutMe?uid=<%=uc.getID()%>"> <img src="images/<%=photoc.getPhotoname()%>" alt="Image placeholder"> </a>
                                        </div>
                                        <div class="comment-body">

                                            <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
                                                <div class="btn-group" role="group">
                                                    <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                        ...
                                                    </button>
                                                    <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                                                        <%
                                                            if (user.getID().equals(uc.getID()) || user.getID().equals(uu.getID())) {


                                                        %>
                                                        <a class="dropdown-item" href="deleteComment?cid=<%=c.getID()%>">Delete Comment</a>
                                                        <%}%>
                                                        <%
                                                            if (!user.getID().equals(uc.getID())) {

                                                        %>
                                                        <a class="dropdown-item" href="#">Report User</a>
                                                        <%}%>
                                                    </div>
                                                </div>
                                            </div>

                                            <a href="aboutMe?uid=<%=uc.getID()%>"><h3 ><%=uc.getDisplayname()%></h3> </a>
                                            <div class="meta"><%=c.getCommentDate()%></div>
                                            <p><%=c.getText()%></p>
                                        </div>
                                    </li>
                                </ul>
                                <%}%>
                                <!-- END comment-list -->

                                <div class="comment-form-wrap pt-5">
                                    <h3 class="mb-5">Leave a comment</h3>
                                    <form action="uploadComment?" method="get" class="p-5 bg-light">
                                        <div class="form-group">
                                            <label for="message">Message</label>
                                            <textarea name="textComment" id="message" cols="30" rows="5" class="form-control" placeholder="Leave your words about this book :)"></textarea>
                                            <input type="hidden" id="message" name="postID" value="<%=poster.getID()%>">
                                        </div>
                                        <div class="form-group">
                                            <input type="submit" value="Post Comment" class="btn btn-primary">
                                        </div>
                                    </form>
                                </div>
                            </div>

                        </div>

                        <!-- END main-content -->

                        <div class="col-md-12 col-lg-4 sidebar">
                            <div class="sidebar-box search-form-wrap">
                                <form action="" class="search-form">
                                    <div class="form-group">
                                        <span class="icon fa fa-search"></span>
                                        <input type="text" class="form-control" id="s" placeholder="Type a keyword and hit enter">
                                    </div>
                                </form>
                            </div>
                            <!-- END sidebar-box -->
                            <div class="sidebar-box">
                                <div class="bio text-center">
                                    <a href="aboutMe?uid=<%=uu.getID()%>"><img src="images/<%=postUserPhoto.getPhotoname()%>" alt="Image Placeholder" class="img-fluid mb-5"> </a>
                                    <div class="bio-body">
                                        <a href="aboutMe?uid=<%=uu.getID()%>"><h2 ><%=uu.getDisplayname()%></h2> </a>
                                        <p><a href="aboutMe?uid=<%=uu.getID()%>" class="btn btn-primary btn-sm rounded px-4 py-2">My profile</a></p>
                                        <p class="social">
                                            <a  class="p-2"><span class="fa fa-facebook"></span></a>
                                            <a  class="p-2"><span class="fa fa-twitter"></span></a>
                                            <a  class="p-2"><span class="fa fa-instagram"></span></a>
                                            <a  class="p-2"><span class="fa fa-youtube-play"></span></a>
                                        </p>
                                    </div>
                                </div>
                            </div>
                            <!-- END sidebar-box -->

                            <div class="sidebar-box">
                                <h3 class="heading">Categories</h3>
                                <ul class="categories">
                                    <%                                        int i = 0;
                                        for (String s : listTopicID) {
                                            Topic topic = topicDAO.getTopicbyTopicID(s);
                                            int countPostByTopic = topicDAO.getCountPostsbyTopicID(topic.getID());
                                            i++;
                                            if (i == 6) {
                                                break;
                                            }
                                    %>
                                    <li><a href="listPostsByTopic?tid=<%=topic.getID()%>"> <%=topic.getText()%> <span>(<%=countPostByTopic%>)</span></a></li>
                                        <%}%>
                                </ul>
                            </div>
                            <!-- END sidebar-box -->

                            <div class="sidebar-box">
                                <h3 class="heading">Tags</h3>
                                <ul class="tags">
                                    <%
                                        for (String s : listTopicID) {
                                            Topic topic = topicDAO.getTopicbyTopicID(s);
                                    %>
                                    <li><a href="listPostsByTopic?tid=<%=topic.getID()%>"><%=topic.getText()%></a></li>
                                        <%}%>
                                </ul>
                            </div>
                        </div>
                        <!-- END sidebar -->

                    </div>
                </div>
            </section>

            <div class="site-footer">
                <div class="container">
                    <div class="row mb-5">
                        <div class="col-md-4">
                            <h3 class="footer-heading mb-4">About Us</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Placeat reprehenderit magnam deleniti quasi saepe, consequatur atque sequi delectus dolore veritatis obcaecati quae, repellat eveniet omnis, voluptatem in. Soluta, eligendi, architecto.</p>
                        </div>
                        <div class="col-md-3 ml-auto">
                            <!-- <h3 class="footer-heading mb-4">Navigation</h3> -->
                            <ul class="list-unstyled float-left mr-5">
                                <li><a>About Us</a></li>
                                <li><a>Advertise</a></li>
                                <li><a>Careers</a></li>
                                <li><a>Subscribes</a></li>
                            </ul>
                            <ul class="list-unstyled float-left">
                                <li><a>Review</a></li>
                                <li><a>Book for you</a></li>
                                <li><a>Self-help</a></li>
                                <li><a>Nature</a></li>
                            </ul>
                        </div>
                        <div class="col-md-4">


                            <div>
                                <h3 class="footer-heading mb-4">Connect With Us</h3>
                                <p>
                                    <a><span class="icon-facebook pt-2 pr-2 pb-2 pl-0"></span></a>
                                    <a><span class="icon-twitter p-2"></span></a>
                                    <a><span class="icon-instagram p-2"></span></a>
                                    <a><span class="icon-rss p-2"></span></a>
                                    <a><span class="icon-envelope p-2"></span></a>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12 text-center">
                            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                        </div>
                    </div>
                </div>
            </div>

        </div>

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
