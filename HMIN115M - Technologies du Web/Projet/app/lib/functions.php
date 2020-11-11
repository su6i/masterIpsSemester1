<?php
// Cours: Web Technologies
// Project: MarmitUM
// Authors: Hassina BOUFATIS, Aicha DERBAL and Amir SHIRALI POUR


/**
 * Render template with data
 */
function render_template2($content = null, $data = [])
{
    $data['menu_items'] = MENU_ITEMS;

    extract($data);

    ob_start();
  
    include TEMPLATES_DIR . '/menu.php';
    include TEMPLATES_DIR . '/header.php';
    include TEMPLATES_DIR . '/body.php';
    include TEMPLATES_DIR . '/footer.php';

    unset($data);
    echo ob_get_clean();
}

function render_template($content = null, $data = [])
{
    $data['menu_items'] = MENU_ITEMS;
  
    $content_path = TEMPLATES_DIR . '/' . $content;
    if (isset($content) && file_exists($content_path)) {
        $data['content'] = $content_path;
    }

    extract($data);
    ob_start();
    include TEMPLATES_DIR . '/layout.php';
    unset($data);
    echo ob_get_clean();
}


/**
 * Render custom template with data
 */
function render_custom_template($view_name, $data)
{
    extract($data);
    ob_start();
    include TEMPLATES_DIR . "/" . $view_name ;
    unset($data);
    echo ob_get_clean();
}


function check_is_valid_user($username, $password)
{
    $users = file_get_contents(DB_DIR . '/users.json');
    $users_data = json_decode($users, true);

    foreach ($users_data as $user) {
        if ($user['email'] == $username && $user['password'] == md5($password)) {
            return [
                'email' => $user['email'],
                'username' => $user['name']
                ];
        }
    }

    return false;
}

/**
 * Check if use is logged in
 */
function is_logged_in()
{
    return (isset($_SESSION['LOGGED_IN']) && !empty($_SESSION['LOGGED_IN']));
}


/**
 *
 */
function prev_url()
{
    return $_COOKIE['PREV_URL'] ? $_COOKIE['PREV_URL'] : '/';
}


/**
 * return path to $image asset
 */
function img_path($image= null)
{
    if (isset($image)) {
        return IMG_PATH . '/' . $image;
    }
}

/**
 * return path to $style asset
 */
function style_path($style = null)
{
    if (isset($style)) {
        return STYLES_PATH . '/' . $style;
    }
}

/**
 * return path to $script asset
 */
function script_path($script= null)
{
    if (isset($script)) {
        return SCRIPTS_PATH . '/' . $script;
    }
}


function get_recipes_list($query_for = null)
{
    $json_string = file_get_contents(DB_DIR . '/data.json');
    $data = json_decode($json_string, true);
    $recipes = $data['data'];

    if (!empty($query_for)) {
        $result = array_filter($recipes, function ($recipe) use ($query_for) {
            foreach ($recipe as $field => $value) {
                $query_for = str_replace('/', '\/', $query_for);
                $pattern = '/' . $query_for . '/i';
                if (preg_match($pattern, $value) == 1) {
                    return true;
                }
            }
        });
        $result = array_values($result);
        $data['data'] = $result;
    }

    return $data;
}


function get_recipe_by_id($id)
{
    $json_string = file_get_contents(DB_DIR . '/data.json');
    $data = json_decode($json_string, true);
    $recipes = $data['data'];
    $last_update = $data['last_update'];

    for ($i = 0; $i < count($recipes); $i++) {
        $recipe = $recipes[$i];

        if ($recipe['id'] == $id) {
            return [
                'recipe' => $recipe,
                'last_update' => $last_update
            ];
        }
    }
    return [
        'recipe' => null,
        'last_update' => $last_update
    ];
}
