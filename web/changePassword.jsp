<%-- 
    Document   : profileIndex
    Created on : Oct 26, 2019, 1:08:08 PM
    Author     : hongq
--%>

<%@page import="until.SessionHelper"%>
<%@page import="models.Photo"%>
<%@page import="dal.PhotoDAO"%>
<%@page import="models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        User userInstance = SessionHelper.getUserFromSession(session);
        PhotoDAO photoDAO = new PhotoDAO();
        Photo userPhotoInstance = photoDAO.getPhotoByUserID(userInstance.getID());
        Photo Uphoto = photoDAO.getPhotoByUserID(userInstance.getID());
    %>
    <head>
        <title><%=userInstance.getDisplayname()%></title>
        <meta charset="utf-8">
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
                <br><br><h1 id="colorlib-logo"><a>Profile<span>.</span></a></h1>
                <nav id="colorlib-main-menu" role="navigation">
                    <ul>
                        <li ><a href="aboutMe?uid=<%=userInstance.getID()%>"> << Back To Profile</a></li>
                        <li class="colorlib-active"><a href="changePassword"> Change password</a></li>
                    </ul>
                </nav>

                <div class="colorlib-footer">
                    <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                </div>
            </aside> <!-- END COLORLIB-ASIDE -->

            <div id="colorlib-main">
                <div class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url(images/<%=Uphoto.getPhotoname()%>);" data-stellar-background-ratio="0.5">
                    <div class="overlay"></div>
                    <div class="js-fullheight d-flex justify-content-center align-items-center">
                        <div class="col-md-6 text ">
                            <div class="contact1">
                                <form action="changePassword" method="post" >
                                    <span>
                                        <h3>Change password : </h3>
                                    </span>
                                    Enter Old Password : <br>
                                    <div >
                                        <input type="password" name="oldPassword" placeholder="Old Password" required>
                                    </div><br>
                                    Enter New Password : <br>
                                    <div >
                                        <input  type="password" name="newPassword1" placeholder="New Password"  required>
                                    </div><br>
                                    Re-enter New Password : <br>
                                    <div >
                                        <input  type="password" name="newPassword2" placeholder="Re-enter New Password" required>
                                    </div><br><br>

                                    <div class="form-group">
                                        <input name="name" type="submit" value="Update" class="btn btn-primary">
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col-md-4 text ">
                            <div class="img mb-6" style="background-image: url(images/<%=Uphoto.getPhotoname()%>);"></div>
                        </div>
                    </div>
                </div>
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
