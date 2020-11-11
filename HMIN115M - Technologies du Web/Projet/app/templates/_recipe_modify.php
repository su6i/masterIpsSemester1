<?php
// Cours: Web Technologies
// Project: MarmitUM
// Authors: Hassina BOUFATIS, Aicha DERBAL and Amir SHIRALI POUR
?>

<div class="album py-5 bg-light">
    <!-- container -->
    <div class="container">
      <!-- /form row -->
      <div class="row">

          <div class="col-md-3">
            <h5>ID:<span class="badge badge-secondary" id="recipe_id"></span></h5>  
          </div>
          <div class="col-md-4">
            <h5>Date:<span class="badge badge-secondary" id="recipe_date"></span></h5>  
          </div>

        <div class="col-md-12">
           <!-- form -->
          <form class="mb-4">
            <!-- form row -->
            <div class="form-row">
              <div class="form-group col-md-4">
                <label for="title">Title</label>
                <input type="title" class="form-control" id="title" placeholder="Title">
              </div>
              <div class="form-group col-md-3">
                <label for="type">Type</label>
                <input type="text" class="form-control" id="type" placeholder="Type">
              </div>
            
            <div class="form-group col-md-3">
              <label for="inputAddress">Category</label>
              <input type="text" class="form-control" id="category" name="category" placeholder="Category">
            </div>
            <div class="form-group col-md-2">
              <label for="inputAddress2">Time of preparation</label>
              <input type="text" class="form-control" id="prepare_time" name="prepare_time" placeholder="Time of preparation">
            </div>
            </div>
            <!-- /form row -->
            <!-- form row -->
            <div class="form-row">
              <div class="form-group col-md-3">
                <label for="inputState">Author</label>
                <input type="text" class="form-control" id="author" name="author" placeholder="Author">
              </div>
              <div class="form-group col-md-3">
                <label for="email">Email</label>
                <input type="text" class="form-control" id="email" name="email" placeholder="Email">
              </div>
              <div class="form-group col-md-4">
                <label for="photo">Photo</label>
                <input type="text" class="form-control" id="photo" name="photo" placeholder="Photo">
              </div>
              <div class="form-group col-md-2">
                <label for="for_persons">For persons</label>
                <input type="text" class="form-control" id="for_persons" name="for_persons" placeholder="for persons">
              </div>
            </div>
            <!-- /form row -->
            <!-- form row -->
            <div class="form-row">
              <div class="form-group col-md-12">
                <label for="ingredients">Ingredients</label>
                <input type="text" class="form-control" id="ingredients" name="ingredients" placeholder="Ingredients">
              </div>

            </div>
            <!-- /form row -->
            
            <button id="add_edit_btn" class="btn btn-primary">Add / Edit</button>
            <button id="clear_btn" class="btn btn-info">Clear</button>
            <button id="load_data_btn" class="btn btn-success float-right">Load Data</button>
          </form>
          <!-- /form -->
        </div>
      </div>
      <!-- /form row -->

      <!-- table row -->
      <div class="row">
        <div class="col md-12">
          <!-- recipes table -->
            <table class="table" id="recipes_table">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">Recipe Title</th>
                  <th scope="col">Author</th>
                  <th scope="col">Date</th>
                  <th scope="col">Category</th>
                  <th scope="col">Edit/Delete</th>
                </tr>
              </thead>
              <tbody>
                <tr></tr>
              </tbody>
            </table>
          <!-- /recipes table -->
        </div>
      </div>
      <!-- /table row -->
    </div>
    <!-- /container -->
  </div>