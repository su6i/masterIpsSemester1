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
    <link href="<?php echo style_path('style.css');?>" rel="stylesheet">
  </head>
  <body>


  <?php include TEMPLATES_DIR . '/_navbar.php'; ?>

	<main role="main">

  <?php if (isset($carousel) && !empty($carousel)): ?>
    <?php include TEMPLATES_DIR . '/_carousel.php'  ; ?>
  <?php endif; ?> 

  <!-- Wrap the rest of the page in another container to center all the content. -->

  <div class="container marketing">

    <?php if (isset($content)): ?>
      <?php include $content; ?>
    <?php endif; ?> 

  </div><!-- /.container -->

  <!-- FOOTER -->
  <?php include TEMPLATES_DIR . '/_footer.php'; ?>

</main>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="https://getbootstrap.com/docs/4.4/assets/js/vendor/jquery.slim.min.js"><\/script>')</script><script src="https://getbootstrap.com/docs/4.4/dist/js/bootstrap.bundle.min.js" integrity="sha384-6khuMg9gaYr5AxOqhkVIODVIvm9ynTT5J4V1cfthmT+emCG6yVmEZsRHdxlotUnm" crossorigin="anonymous"></script>
  
    <script src="<?php echo script_path('main.js');?>"></script>
    </body>

</html>
