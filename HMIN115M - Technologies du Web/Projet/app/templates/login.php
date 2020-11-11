<?php
// Cours: Web Technologies
// Project: MarmitUM
// Authors: Hassina BOUFATIS, Aicha DERBAL and Amir SHIRALI POUR
?>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title><?php echo $PageTitle;?></title>

    <!-- Bootstrap core CSS -->
<link href="https://getbootstrap.com/docs/4.4/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
   <!-- Custom styles for this template -->
    <link href="<?php echo style_path('login.css');?>" rel="stylesheet">
  </head>
  <body>
    <form class="form-signin" method="post" action="/login">
  <div class="text-center mb-4">
    <img class="mb-4" src="<?php echo img_path('logo.png');?>" alt="" width="72" height="72">
  </div>

  <div class="form-label-group">
    <input type="email" id="email" name="email" 
    class="form-control <?php echo ($login_error) ? 'is-invalid' : '';?>" placeholder="Email address" required autofocus>
    <label for="inputEmail">Email address</label>
    
    <?php if ($login_error): ?>
        <div class="invalid-feedback">
              Please enter a valid email.
        </div>
    <?php endif;?>
  </div>

  <div class="form-label-group">
    <input type="password" id="password" name="password" 
    class="form-control <?php echo ($login_error) ? 'is-invalid' : '';?>" placeholder="Password" required>
    <label for="inputPassword">Password</label>

     <?php if ($login_error): ?>
        <div class="invalid-feedback">
              Enter your password correctly.
        </div>
    <?php endif; ?>

  </div>

  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  <a href="<?php echo $prev_url;?>" class="btn btn-lg btn-success btn-block" type="submit">Back</button>
</form>
</body>
</html>
