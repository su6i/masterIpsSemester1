<?php
// Cours: Web Technologies
// Project: MarmitUM
// Authors: Hassina BOUFATIS, Aicha DERBAL and Amir SHIRALI POUR



function checkAPICall()
{
    $request = [];
    $request['method'] = $_SERVER['REQUEST_METHOD'];
    $request['url'] = rtrim($_SERVER['REQUEST_URI'], '/');
  
    $trimmed_url = ltrim($_SERVER['REQUEST_URI'], '/');
    $url_parts = explode('/', $trimmed_url);

    $request['url_parts'] = $url_parts;

    if (in_array($_SERVER['REQUEST_METHOD'], ['POST', 'PUT'])) {
        $request['body'] = json_decode(file_get_contents('php://input'), true);
    }
  
    if ($url_parts[0] === 'api') {
        array_shift($url_parts);
        if (count($url_parts) >= 1) {
            $api_function_name = array_shift($url_parts);
            $params = $url_parts;
            $request['params'] = $params;
            array_unshift($params, $request);

            $request_uri = $request['method'] . ' /' . $api_function_name;
            if (array_key_exists($request_uri, API_FN)) {
                call_user_func_array(API_FN[$request_uri], $params);
            } else {
                http_response_code(405);
                echo json_encode(["message" => "Method Not Allowed"]);
            }
        } else {
            http_response_code(405);
            echo json_encode(["message" => "Method Not Allowed"]);
        }
        die();
    }
}

function get_recipes($request)
{
    header('Content-Type: application/json');
    http_response_code(200);
    $json_string = file_get_contents(DB_DIR . '/data.json');
    $data = json_decode($json_string, true);
    echo json_encode($data['data']);
}

function get_recipe($request, $id)
{
    $id = (int)$id;
    header('Content-Type: application/json');
    http_response_code(200);
    $json_string = file_get_contents(DB_DIR . '/data.json');
    $data = json_decode($json_string, true);
    $recipes = $data['data'];

    $index = array_search($id, array_column($recipes, "id"));
    if ($index !== false && $recipes[$index]) {
        echo json_encode($recipes[$index]);
    } else {
        echo json_encode(["message" => "Recipe not found."]);
    }
}

function delete_recipe($request, $id)
{
    $id = (int)$id;
    header('Content-Type: application/json');
    if (!is_logged_in()) {
        http_response_code(403);
        die();
    }

    http_response_code(200);

    $json_string = file_get_contents(DB_DIR . '/data.json');
    $data = json_decode($json_string, true);
    $recipes = $data['data'];

    $index = array_search($id, array_column($recipes, "id"));
    if ($index !== false && $recipes[$index]) {
        // remove specified index and reindex the recipes array
        unset($recipes[$index]);
        $recipes = array_values($recipes);
        $result = [];
        $result['last_update'] = date('Y-m-d H:i:s');
        $result['data'] = $recipes;
        $json = json_encode($result, JSON_PRETTY_PRINT);
        file_put_contents(DB_DIR . '/data.json', $json);
        echo json_encode($result);
    } else {
        echo json_encode(["message" => "Error deleting record."]);
    }
}

function add_recipe($request)
{
    header('Content-Type: application/json');
    if (!is_logged_in()) {
        http_response_code(403);
        die();
    }

    http_response_code(200);

    $json_string = file_get_contents(DB_DIR . '/data.json');
    $data = json_decode($json_string, true);
    $recipes = $data['data'];
    $ids = array_column($recipes, "id");

    if (count($ids) > 0) {
        $new_id = max($ids) + 1;
        $new_recipe = [
            "id" => $new_id,
            "recipeTitle" => $request['body']['title'],
            "typeOfRecipe" => $request['body']['type'],
            "category" => $request['body']['category'],
            "timeOfPreparation" => $request['body']['prepare_time'],
            "for_persons" => $request['body']['for_persons'],
            "author" => $request['body']['author'],
            "email" => $request['body']['email'],
            "ingredients" => $request['body']['ingredients'],
            "title" => $request['body']['title'],
            "photo" => $request['body']['photo'],
            "date" => date('d-m-Y')
        ];

        $recipes[] = $new_recipe;
        $recipes = array_values($recipes);
        $result = [];
        $result['last_update'] = date('Y-m-d H:i:s');
        $result['data'] = $recipes;
        $json = json_encode($result, JSON_PRETTY_PRINT);
        file_put_contents(DB_DIR . '/data.json', $json);
        echo json_encode($result);
    } else {
        echo json_encode(["message" => "Error deleting record."]);
    }
}


function update_recipe($request)
{
    header('Content-Type: application/json');
    if (!is_logged_in()) {
        http_response_code(403);
        die();
    }
    
    http_response_code(200);

    $json_string = file_get_contents(DB_DIR . '/data.json');
    $data = json_decode($json_string, true);
    $recipes = $data['data'];
    $id = $request['params'][0];

    $recipe = null;
    $index = null;
    for ($i = 0; $i < count($recipes); $i++) {
        if ($recipes[$i]['id'] == $id) {
            $recipe = $recipes[$i];
            $index = $i;
            break;
        }
    }

    if (!empty($recipe) && isset($index)) {
        $updated_recipe = [
            "id" => $recipe['id'],
            "recipeTitle" => $request['body']['title'],
            "typeOfRecipe" => $request['body']['type'],
            "category" => $request['body']['category'],
            "timeOfPreparation" => $request['body']['prepare_time'],
            "for_persons" => $request['body']['for_persons'],
            "author" => $request['body']['author'],
            "email" => $request['body']['email'],
            "ingredients" => $request['body']['ingredients'],
            "title" => $request['body']['title'],
            "photo" => $request['body']['photo'],
            "date" => date('d-m-Y')
        ];

        $recipes[$index] = $updated_recipe;

        $recipes = array_values($recipes);
        $result = [];
        $result['last_update'] = date('Y-m-d H:i:s');
        $result['data'] = $recipes;
        $json = json_encode($result, JSON_PRETTY_PRINT);
        file_put_contents(DB_DIR . '/data.json', $json);

        echo json_encode($result);
    }
}
