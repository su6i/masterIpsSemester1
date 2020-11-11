<?php
// Cours: Web Technologies
// Project: MarmitUM
// Authors: Hassina BOUFATIS, Aicha DERBAL and Amir SHIRALI POUR
?>

<div class="album py-5 bg-light">
    <div class="container">

      <div class="row">
        
        <div class="col-md-12">
          <?php if (!empty($recipe)): ?>
          <div class="card mb-4 shadow-sm">
            <div class="text-center">
             
             <img src="<?php echo $recipe->photo;?>" height="255" class="bd-placeholder-img card-img-top" width="100%">
                <?php echo $recipe->recipeTitle;?>
            </div>
       
            <div class="card-body">
              <p class="card-text">
                <?php echo $recipe->ingredients; ?>
              </p>
                <small class="text-muted"><?php echo $recipe->date; ?></small>
              </div>
            </div>
          <?php else: ?>
            <h2> Not Found </h2>
          <?php endif; ?>
          </div>
          <!-- col-md-12 -->
        </div>
        <!-- row -->
      </div>
    </div>
  </div>