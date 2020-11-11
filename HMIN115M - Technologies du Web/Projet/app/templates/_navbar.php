<?php
// Cours: Web Technologies
// Project: MarmitUM
// Authors: Hassina BOUFATIS, Aicha DERBAL and Amir SHIRALI POUR
?>

<header>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <!-- Navbar header -->
      <ul class="navbar-nav mr-auto">
        <?php foreach ($menu_items as $label => $link): ?>
          <li class="nav-item active">
            <a class="nav-link" href="/<?php echo $link; ?>">
              <?php echo $label; ?>
            </a>
          </li>
        <?php endforeach; ?>

        <?php if (is_logged_in()): ?>
          <li class="nav-item active">
            <a class="nav-link" href="/modify">
              Modifier
            </a>
          </li>        
        <?php endif; ?>
        <?php if (is_logged_in()): ?>
        <li class="nav-item">
          <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">
            Bonjour, <?php echo $_SESSION['LOGGED_IN']['username'];?>
          </a>
        </li>
      <?php endif;?>
      </ul>
      <!-- /Navbar header -->

      <!-- Search -->
      <form class="form-inline mt-2 mt-md-0" action="/recipes" method="get">
        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" name="search" id="search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
      <!-- /Search -->

      <?php if (is_logged_in()): ?>
       <a href="/logout" class="btn btn-outline-success my-2 my-sm-0" >Logout</a>
      <?php else: ?>
        <a href="/login" class="btn btn-outline-success my-2 my-sm-0" >Login</a>
       <?php endif; ?> 
    </div>
  </nav>
</header>