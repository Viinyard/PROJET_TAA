# projet_taa

Pour POST une entreprise (avec postman par exemple) :
Dans body : raw puis application/json
dans headers : vérifier qu'il y a : Content-Type : application/json
Régler la requête sur POST à cette addresse : localhost:8080/enterprise
Dans body mettre :
{
	"creationDate" : "12-12-2012",
	"label" : "Capgemini",
	"siretNumber" : "121212",
	"taxYear" : "2018"
}
réponse attendue :
{
    "id": 1,
    "label": "Capgemini",
    "creationDate": "12-12-2012",
    "taxYear": 2018,
    "siretNumber": "121212",
    "_links": {
        "self": {
            "href": "http://localhost:8080/enterprise/1"
        },
        "cPEnterprise": {
            "href": "http://localhost:8080/enterprise/1"
        },
        "addresses": {
            "href": "http://localhost:8080/enterprise/1/addresses"
        },
        "employees": {
            "href": "http://localhost:8080/enterprise/1/employees"
        },
        "attachments": {
            "href": "http://localhost:8080/enterprise/1/attachments"
        },
        "phoneNumbers": {
            "href": "http://localhost:8080/enterprise/1/phoneNumbers"
        }
    }
}

ensuite ajout d'un numero de téléphone à l'entreprise :
On commence par créer un numéro de téléphone :
Dans body : raw puis application/json
dans headers : vérifier qu'il y a : Content-Type : application/json
Régler la requête sur POST à cette addresse : http://localhost:8080/phoneNumber
Dans body mettre :
{
	"phoneNumber" : "0627759886",
	"phoneType" : "portable"
}
réponse attendue :
{
    "id": 2,
    "phoneNumber": "0627759886",
    "phoneType": "portable",
    "_links": {
        "self": {
            "href": "http://localhost:8080/phoneNumber/2"
        },
        "cPPhoneNumber": {
            "href": "http://localhost:8080/phoneNumber/2"
        }
    }
}

Ensuite on fait le lien entre l'entreprise et le numéro de téléphone :
Régler la requête sur PUT à cette addresse : http://localhost:8080/enterprise/1/phoneNumbers
(Pour l'entreprise 1 on accède à ses numéros de téléphone et on met à jour la liste (on ajoute un)
ATTETION cette fois dans content list mettre : Content-Type : text/uri-list
et dans le body on met le lien URI de notre numéro de téléphone précédement créé :
http://localhost:8080/phoneNumber/2
