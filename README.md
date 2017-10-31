# ServerRestfullOCR

Demo  ServerRestFullOCR fait avec Spring RESTful Web Service et Spring Boot

- Comment lancer le serveur (prérequis connexion Internet et installer unique Maven )

Se positionner à la racine du projet et taper la commande

./mvnw spring-boot:run

- Services Rest exposés par le serveur

   ---  /tesseractwithdefaultimage (http://localhost:8080/tesseractwithdefaultimage)

qui renvoi le texte en Json de l'image d'une carte d'identité (\src\main\java\hello\id6.jpg enregistrer sur le serveur

   ---  /tesseractwithdefaulturl (http://localhost:8080/tesseractwithdefaulturl?url=http://afrinnov.xyz/id6.jpg )

qui renvoi le texte en Json d'une image a partie de son url ex : http://afrinnov.xyz/id6.jpg


   ---  /tesseractwithimageencodetostring

qui renvoi le texte en Json d'une image encodé en StringBase64 puis envoyer par la méthode POST via la classe Image \src\main\java\hello\Image.java (DTO)
