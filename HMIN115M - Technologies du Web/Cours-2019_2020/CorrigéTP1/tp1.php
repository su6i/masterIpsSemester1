<html>

	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="style.css">
		<title>Technologies du Web - TP 1</title>
	</head>

	<body>
		<h1>Tarte aux prunes</h1>

		<h2>Ingrédients pour 8</h2>
		<ol>
			<li>1 pâte brisée</li>
			<li>500G prunes dénoyautées</li>
			<li>2 œufs</li>
			<li>75g de sucre</li>
			<li>100g crème fraîche</li>
		</ol>

		<h2>Préparation</h2>
		<p>
			Préchauffez le four à 180 deg. (Th. 6)
		</p>
		<p>
			Couper les prunes en deux. Mélanger les œufs, le sucre et la crème fraîche…
		</p>

		<h2>Images</h2>

		<table>
			<thead>
				<tr>
					<td>Titre</td>
					<td>Image</td>
				</tr>
			</thead>
			<tbody>
			<?php
				$mesImages = [
					"Magnifique tarte" => "https://static.cuisineaz.com/400x320/i11926-tarte-aux-prunes-a-l-amande.jpg",
					"Tarte exceptionnelle" => "https://cache.marieclaire.fr/data/photo/w1000_c17/cuisine/4n/tarte-alsacienne-aux-prunes-123.jpg",
					"La tarte qui casse tout" => "https://www.foodette.fr/files/products/tarte-amandine-prunes-poudre-de-noisettes-amandes.JPG"
				];
				foreach ($mesImages as $titre => $adresse) {
					echo "<tr> <td>$titre</td> <td><img src=\"$adresse\"></td> </tr>";
				}
			?>
			</tbody>
		</table>

	</body>
</html>
