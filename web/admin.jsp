<%-- 
    Document   : admin
    Created on : Nov 09, 2019, 8:36:13 AM
    Author     : hongq
--%>

<%@page import="dal.UserDAO"%>
<%@page import="models.Report"%>
<%@page import="java.util.ArrayList"%>
<%@page import="until.SessionHelper"%>
<%@page import="models.Photo"%>
<%@page import="dal.PhotoDAO"%>
<%@page import="models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%
        User userInstance = SessionHelper.getUserFromSession(session);
        PhotoDAO photoDAO = new PhotoDAO();
        Photo userPhotoInstance = photoDAO.getPhotoByUserID(userInstance.getID());
        UserDAO userDAO = new UserDAO();
        ArrayList<Report> listReport = (ArrayList<Report>) request.getAttribute("listReport");
        Report instanceReport = (Report) request.getAttribute("instanceReport");
        User instanceReportedUser = userDAO.getUserByUserID(instanceReport.getUser().getID());
        Photo instancePhotoReportedUser = photoDAO.getPhotoByUserID(userInstance.getID());
    %>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Responsive Admin Dashboard Template">
        <meta name="keywords" content="admin,dashboard">
        <meta name="author" content="skcats">
        <!-- The above 6 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <!-- Title -->
        <title>Admin Dashboard</title>

        <!-- Styles -->
        <link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
        <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="assets/plugins/icomoon/style.css" rel="stylesheet">
        <link href="assets/plugins/uniform/css/default.css" rel="stylesheet" />
        <link href="assets/plugins/switchery/switchery.min.css" rel="stylesheet" />
        <link href="assets/plugins/summernote-master/summernote.css" rel="stylesheet" type="text/css" />

        <!-- Theme Styles -->
        <link href="assets/css/ecaps.min.css" rel="stylesheet">
        <link href="assets/css/custom.css" rel="stylesheet">

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
    <body class="page-sidebar-collapsed">

        <!-- Page Container -->
        <div class="page-container">

            <!-- Page Content -->
            <div class="page-content">
                <!-- Page Header -->
                <div class="page-header">
                    <div class="search-form">
                        <form action="#" method="GET">
                            <div class="input-group">
                                <input type="text" name="search" class="form-control search-input"
                                       placeholder="Type something...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" id="close-search" type="button"><i
                                            class="icon-close"></i></button>
                                </span>
                            </div>
                        </form>
                    </div>
                    <nav class="navbar navbar-default">
                        <div class="container-fluid">
                            <!-- Brand and toggle get grouped for better mobile display -->
                            <div class="navbar-header">
                                <div class="logo-sm">
                                    <a href="javascript:void(0)" id="sidebar-toggle-button"><i class="fa fa-bars"></i></a>
                                    <a class="logo-box" href="index.html"><span>ecaps</span></a>
                                </div>
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                    <i class="fa fa-angle-down"></i>
                                </button>
                            </div>

                            <!-- Collect the nav links, forms, and other content for toggling -->
                        </div><!-- /.container-fluid -->
                    </nav>
                </div><!-- /Page Header -->
                <!-- Page Inner -->
                <div class="page-inner">
                    <div id="main-wrapper">
                        <div class="cross-page-line"></div>
                        <div class="row">
                            <div class="col-md-2">
                                <div class="email-actions">
                                </div>
                                <div class="email-menu">
                                    <ul class="list-unstyled">
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="email-list">
                                    <ul class="list-unstyled">
                                        <%
                                            for (Report r : listReport) {
                                                User reportedUser = userDAO.getUserByUserID(r.getUser().getID());
                                                Photo reportedUserPhoto = photoDAO.getPhotoByUserID(r.getUser().getID());
                                        %>
                                        <li class="active">
                                            <a href="admin?rid=<%=r.getID()%>">
                                                <div class="email-list-item">
                                                    <div class="email-author">
                                                        <img src="images/<%=reportedUserPhoto.getPhotoname()%>" alt="">
                                                        <span class="author-name"><%=reportedUser.getDisplayname()%></span>
                                                        <span class="email-date"><%=r.getReportDate()%></span>
                                                    </div>
                                                    <div class="email-info">
                                                        <span class="email-subject">
                                                            <%=(r.getContent().length() >= 20) ? (r.getContent().substring(0, 20) + "...") : r.getContent()%>
                                                        </span>
                                                        <span class="email-text">
                                                            <%=(r.getText().length() >= 20) ? (r.getText().substring(0, 20) + "...") : r.getText()%>
                                                        </span>
                                                    </div>
                                                </div>
                                            </a>
                                        </li>
                                        <%}%>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-7">
                                <div class="email-actions">
                                    <a href="singlePost?poid=<%=instanceReport.getPoster().getID()%>" class="btn btn-default">Review Post</a>
                                    <a href="deleteReport?rid=<%=instanceReport.getID()%>" class="btn btn-default">Delete Report</a>
                                    <a href="deletePost?poid=<%=instanceReport.getPoster().getID()%>" class="btn btn-danger">Delete Reported Post</a>
                                </div>
                                <div class="email">
                                    <div class="email-header">
                                        <div class="email-title">
                                            <p><%=instanceReport.getContent()%></p>
                                        </div>
                                        <span class="divider"></span>
                                        <div class="email-author">
                                            <img src="images/<%=instancePhotoReportedUser.getPhotoname()%>" alt="">
                                            <span class="author-name"><%=instanceReportedUser.getDisplayname()%></span>
                                            <span class="email-date"><%=instanceReport.getReportDate()%></span>
                                        </div>
                                        <span class="divider"></span>
                                    </div>
                                    <div class="email-body">
                                        <span>
                                            <%=instanceReport.getText()%>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div><!-- Row -->
                    </div><!-- Main Wrapper -->
                    <div class="page-footer">
                        <p>Made with <i class="fa fa-heart"></i> by skcats</p>
                    </div>
                </div><!-- /Page Inner -->
            </div><!-- /Page Content -->
        </div><!-- /Page Container -->


        <!-- Javascripts -->
        <script src="assets/plugins/jquery/jquery-3.1.0.min.js"></script>
        <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
        <script src="assets/plugins/uniform/js/jquery.uniform.standalone.js"></script>
        <script src="assets/plugins/switchery/switchery.min.js"></script>
        <script src="assets/plugins/summernote-master/summernote.min.js"></script>
        <script src="assets/js/ecaps.min.js"></script>
        <script src="assets/js/pages/email.js"></script>

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