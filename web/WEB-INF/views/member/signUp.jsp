<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<section class="search-section">
    <div class="container">
        <div class="row subscribe-from">
            <div class="col-md-12">
                <form class="form-inline col-md-12 wow fadeInDown animated">
                    <div class="form-group">
                        <input type="email" class="form-control subscribe" id="email" placeholder="Search...">
                        <button class="suscribe-btn" ><i class="pe-7s-search"></i></button>
                    </div>
                </form><!-- end /. form -->
            </div>
        </div><!-- end of/. row -->
    </div><!-- end of /.container -->
</section><!-- end of /.news letter section -->

<div class="container">
    <form role="form" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="form-group row">
            <label for="member_email" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="member_email" name="member_email" placeholder="Email">
            </div>
        </div>
        <div class="form-group row">
            <label for="member_nick" class="col-sm-2 col-form-label">Nick</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="member_nick" name="member_nick" placeholder="Nick">
            </div>
        </div>
        <div class="form-group row">
            <label for="member_password" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="member_password" name="member_password" placeholder="Password">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-primary">Sign up</button>
            </div>
        </div>
    </form>
</div>




