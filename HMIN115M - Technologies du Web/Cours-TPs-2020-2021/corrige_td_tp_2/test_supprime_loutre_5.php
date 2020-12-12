<?php

echo "Test: suppression de la loutre d'identifiant 5\n";

require_once("libLoutre.php");

$ret = deleteLoutreById(5);
var_dump($ret);
