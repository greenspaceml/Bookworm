<%-- 
    Document   : liist
    Created on : Oct 19, 2019, 9:47:40 AM
    Author     : hongq
--%>

<%@page import="dal.UserDAO"%>
<%@page import="dal.PosterDAO"%>
<%@page import="dal.CommentDAO"%>
<%@page import="models.Topic"%>
<%@page import="dal.TopicDAO"%>
<%@page import="models.Poster"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dal.PhotoDAO"%>
<%@page import="models.Photo"%>
<%@page import="until.SessionHelper"%>
<%@page import="models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bookworm</title>
        <%
            User user = SessionHelper.getUserFromSession(session);

            ArrayList<Poster> posters = (ArrayList<Poster>) request.getAttribute("posters");

            PhotoDAO photoDAO = new PhotoDAO();
            TopicDAO topicDAO = new TopicDAO();
            CommentDAO commentDAO = new CommentDAO();
            PosterDAO posterDAO = new PosterDAO();
            UserDAO userDAO = new UserDAO();

            Photo photoInstance = photoDAO.getPhotoByUserID(user.getID());

            int iRecent = 0;
            int iHighlight = 0;
            ArrayList<Topic> listTopic = topicDAO.getTopics();
            ArrayList<Poster> IDPosterHighlights = posterDAO.getIDPostersByHighlight();
        %>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!--        <meta http-equiv="refresh" content="5">-->

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
                        <!-- LOGO--------------------------------------------------------------------------------------------- -->
                        <div class="col-5 site-logo">
                            <a href="list" class="text-black h2 mb-0">Bookworm</a>
                        </div>

                        <div class="container1">
                            <ul>
                                <form action="searchNameResult" method="get">
                                    <input type="text"  name="searchText" placeholder="Search...">
                                    <div class="search1"></div>
                                    <input type="submit" style="position: absolute; left: -9999px"/>
                                </form>
                            </ul>
                        </div>

                        <!-- Option--------------------------------------------------------------------------------------------- -->
                        <div class="col-7 text-center">
                            <nav class="site-navigation" role="navigation">
                                <ul class="site-menu js-clone-nav mr-auto d-none d-lg-block mb-0">
                                    <li><a href="list">Home</a></li>
                                    <a href="aboutMe?uid=<%=user.getID()%>"><img  src="images/<%=photoInstance.getPhotoname()%>" alt="" width="42" height="42"/> </a>
                                    <li><a href="aboutMe?uid=<%=user.getID()%>"> <%=user.getDisplayname()%> </a></li>
                                    <li><a href="logout"> Logout </a></li>
                                </ul>
                            </nav>
                            <a href="#" class="site-menu-toggle js-menu-toggle text-black d-inline-block d-lg-none"><span
                                    class="icon-menu h3"></span></a>
                        </div>
                    </div>
                </div>
            </header>



            <div class="site-section bg-light">
                <div class="container">
                    <div class="row align-items-stretch retro-layout-2">

                        <div class="comment-form-wrap pt-5">

                            <form action="uploadPost" method="get" class="p-5 bg-light">
                                <div class="form-group">
                                    <div class="col-md-8">
                                        <h4>Write something about the book you read today:</h4> <br>
                                        <div class="btn-group" role="group" aria-label="Button group with nested dropdown">
                                            <div class="btn-group" role="group">
                                                <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                    Choose your Topics:
                                                </button> 
                                                <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                                                    <%
                                                        for (Topic t : listTopic) {
                                                    %>
                                                    &nbsp;<input id="<%=t.getID()%>" type="checkbox" name="tid" value="<%=t.getID()%>" size="100" > &nbsp; <%=t.getText()%><br>
                                                    <%}%>
                                                </div>
                                            </div>
                                        </div>
                                        <input type="text" name="posterName" size="75" placeholder="What is the name of the book?"> <br><br>
                                        <textarea name="posterText" id="message"  cols="200" rows="8" class="form-control" placeholder="Write you own review about this book :)"></textarea>
                                        Select a file: <input type="file" name="myFile"><br><br>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="submit" value="Post To Bookworm" class="btn btn-primary">
                                </div>
                            </form>

                        </div>
                    </div>
                </div>

            </div>
            <!-- Recent posts--------------------------------------------------------------------------------------------- -->
            <div class="site-section bg-light">
                <div class="container">
                    <div class="row mb-5">
                        <div class="col-12">
                            <h2>Recent Posts</h2>
                        </div>
                    </div>
                    <div class="row align-items-stretch retro-layout-2">
                        <%
                            for (Poster p : posters) {
                                iRecent++;
                                if (iRecent == 10) {
                                    break;
                                }
                                ArrayList<Topic> topics = topicDAO.getTopicsByPostID(p.getID());
                        %>
                        <div class="col-md-4">
                            <!-- R post 1--------------------------------------------------------------------------------------------- -->
                            <a href="singlePost?poid=<%=p.getID()%>" target="_blank" class="h-entry mb-30 v-height gradient"
                               style="background-image: url('images/<%=p.getImage()%>');">
                                <div class="text">
                                    <div class="post-categories mb-3">
                                        <%
                                            for (Topic t : topics) {
                                        %>
                                        <span class="post-category bg-danger"><%=t.getText()%></span>
                                        <%}%>
                                    </div>
                                    <h2><%=p.getPostName()%></h2>
                                    <span class="date"><%=p.getPostingDate()%></span> <br>
                                    <span class="date"><%=commentDAO.getCommentCountByPostID(p.getID())%> <%=(commentDAO.getCommentCountByPostID(p.getID()) <= 1) ? "Comment" : "Comments"%></span>
                                </div>
                            </a>
                        </div>
                        <%}%>

                    </div>
                </div>
            </div>

            <!-- Highlight Posts--------------------------------------------------------------------------------------------- -->
            <div class="site-section">
                <div class="container">
                    <div class="row mb-5">
                        <div class="col-12">
                            <h2>Highlight</h2>
                        </div>
                    </div>
                    <div class="row">
                        <!-- H post 1--------------------------------------------------------------------------------------------- -->
                        <%
                            for (Poster p : IDPosterHighlights) {
                                Poster pp = posterDAO.getPosterByID(p.getID());
                                iHighlight++;

                                if (iHighlight == 7) {
                                    break;
                                }

                                ArrayList<Topic> topics = topicDAO.getTopicsByPostID(pp.getID());
                                User uu = userDAO.getUserByPostID(pp.getID());
                                Photo postUserPhoto = photoDAO.getPhotoByUserID(uu.getID());
                        %>
                        <div class="col-lg-4 mb-4">
                            <div class="entry2">
                                <a href="singlePost?poid=<%=pp.getID()%>" target="_blank"><img src="images/<%=pp.getImage()%>" alt="Image" class="img-fluid rounded"></a>
                                <div class="excerpt">
                                    <%
                                        for (Topic t : topics) {

                                    %>
                                    <span class="post-category text-white bg-secondary mb-3"><%=t.getText()%></span>
                                    <%}%>
                                    <h2><a href="singlePost?poid=<%=p.getID()%>" target="_blank"><%=pp.getPostName()%></a></h2>
                                    <div class="post-meta align-items-center text-left clearfix">
                                        <a href="aboutMe?uid=<%=uu.getID()%>"><figure class="author-figure mb-0 mr-3 float-left"> <img  src="images/<%=postUserPhoto.getPhotoname()%>" alt="Image"
                                                                                                                                        class="img-fluid"></figure> </a>
                                        <span class="d-inline-block mt-1">By <a href="aboutMe?uid=<%=uu.getID()%>"><%=uu.getDisplayname()%></a></span>
                                        <span>&nbsp;-&nbsp; <%=pp.getPostingDate()%></span> <br>
                                        <span class="date"><%=commentDAO.getCommentCountByPostID(pp.getID())%> <%=(commentDAO.getCommentCountByPostID(pp.getID()) <= 1) ? "Comment" : "Comments"%></span>
                                    </div>

                                    <p><%=pp.getText().substring(0, 100) + "..."%></p>
                                    <p><a href="singlePost?poid=<%=p.getID()%>">Read More</a></p>
                                </div>
                            </div>
                        </div>
                        <%}%>
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
