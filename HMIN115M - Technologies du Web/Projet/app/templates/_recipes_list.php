<?php
// Cours: Web Technologies
// Project: MarmitUM
// Authors: Hassina BOUFATIS, Aicha DERBAL and Amir SHIRALI POUR
?>

<div class="album py-5 bg-light">
    <div class="container">

      <div class="row">

        <?php foreach ($recipes as $recipe): ?>
        <?php $recipe = (object)$recipe;?>
        <div class="col-md-4">
          <div class="card mb-4 shadow-sm">
            <div class="text-center">
             
             <img src="<?php echo $recipe->photo;?>" height="255" class="bd-placeholder-img card-img-top" width="100%">
                <?php echo $recipe->recipeTitle;?>
            </div>
       
            <div class="card-body">
              <p class="card-text">
                <?php echo mb_strimwidth($recipe->ingredients, 0, 30); ?>
              </p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <a href="/recipe/<?php echo $recipe->id;?>" type="button" class="btn btn-sm btn-outline-secondary">
                  View
                </a>
                <?php if (is_logged_in()): ?>
<!--                   <a href="/edit_recipe/<?php echo $recipe->id;?>" type="button" class="btn btn-sm btn-outline-secondary">
                  Edit
                </a>
 -->                <?php endif; ?>
                </div>
                <small class="text-muted"><?php echo $recipe->date; ?></small>
              </div>
            </div>
          </div>
        </div>
        <?php endforeach; ?>
      </div>
    </div>
  </div>