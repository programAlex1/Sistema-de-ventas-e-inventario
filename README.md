# Documentación de la API de Ventas e Inventario de una Libreria

## Introducción

La API de Ventas e Inventario permite gestionar la información de una lista de productos y realizar el proceso de ventas.

## Recursos

# Libros

## Obtener todos los libros

- Método: GET
- URL: `/books`

**Request:**

```
[GET] http://localhost:8080/books
```
**Response:** 
```json
[
    {
        "id": 1,
        "title": "Los tres cerditos",
        "idAuthor": {
            "id": 3,
            "name": "Ricardo Palma"
        },
        "idEmployee": {
            "id": 2,
            "name": "Luis",
            "lastname": "Diaz",
            "cellphonenumber": "94447154",
            "email": "luis@gmail.com",
            "dateofbirth": "2004-10-23",
            "genre": "Masculino",
            "dni": "111142214"
        },
        "price": 25.0,
        "numberOfPages": 100,
        "stock": 1,
        "idTypeBook": {
            "id": 1,
            "name": "Animado"
        },
        "idPublishing": {
            "id": 2,
            "name": "Futura"
        }
    }
   // ...
]
```
## Obtener un solo libro

- Método: GET
- URL: `/books/{id}`

**Request:**

```
[GET] http://localhost:8080/books/2
```
**Response:** 
```json
{
    "id": 2,
    "title": "El espacio",
    "idAuthor": {
        "id": 1,
        "name": "Da vincci"
    },
    "idEmployee": {
        "id": 1,
        "name": "Andrea",
        "lastname": "Coronel",
        "cellphonenumber": "987654323",
        "email": "andrea@gmail.com",
        "dateofbirth": "2000-09-15",
        "genre": "Masculino",
        "dni": "95959595"
    },
    "price": 35.0,
    "numberOfPages": 145,
    "stock": 0,
    "idTypeBook": {
        "id": 2,
        "name": "Ciencia Ficcion"
    },
    "idPublishing": {
        "id": 3,
        "name": "Macro"
    }
}
```
## Obtener libros por tipo de libro

- Método: GET
- URL: `/books/typebook/{idTypeBook}`

**Request:**

```
[GET] http://localhost:8080/books/typebook/2
```
**Response:** 
```json
[
    {
        "id": 2,
        "title": "El espacio",
        "idAuthor": {
            "id": 1,
            "name": "Da vincci"
        },
        "idEmployee": {
            "id": 1,
            "name": "Andrea",
            "lastname": "Coronel",
            "cellphonenumber": "987654323",
            "email": "andrea@gmail.com",
            "dateofbirth": "2000-09-15",
            "genre": "Masculino",
            "dni": "95959595"
        },
        "price": 35.0,
        "numberOfPages": 145,
        "stock": 0,
        "idTypeBook": {
            "id": 2,
            "name": "Ciencia Ficcion"
        },
        "idPublishing": {
            "id": 3,
            "name": "Macro"
        }
    }
    // ...
]
```
## Obtener libros por rango de precio

- Método: GET
- URL: `/books/by-price`
- Query parameters: `precioMin y precioMax`
  
**Request:**

```
[GET] http://localhost:8080/books/by-price?precioMin=25&precioMax=65
```
**Response:** 
```json
[
    {
        "id": 2,
        "title": "El espacio",
        "idAuthor": {
            "id": 1,
            "name": "Da vincci"
        },
        "idEmployee": {
            "id": 1,
            "name": "Andrea",
            "lastname": "Coronel",
            "cellphonenumber": "987654323",
            "email": "andrea@gmail.com",
            "dateofbirth": "2000-09-15",
            "genre": "Masculino",
            "dni": "95959595"
        },
        "price": 35.0,
        "numberOfPages": 145,
        "stock": 0,
        "idTypeBook": {
            "id": 2,
            "name": "Ciencia Ficcion"
        },
        "idPublishing": {
            "id": 3,
            "name": "Macro"
        }
    }
    //..
]
```
## Crear un Libro

- Método: POST
- URL: `/books`
  
**Request:**

```
[GET] http://localhost:8080/books
```
**# Body**
```json
{
    "title":"El espacio",
    "idAuthor":{
        "id":1
    },
    "idEmployee":{
        "id":1
    },
    "price":35,
    "numberOfPages":145,
    "stock":20,
    "idTypeBook":{
        "id":2
    },
    "idPublishing":{
        "id":3
    }
}
```
**Response:** 
```json
[
    {
        "id": 2,
        "title": "El espacio",
        "idAuthor": {
            "id": 1,
            "name": "Da vincci"
        },
        "idEmployee": {
            "id": 1,
            "name": "Andrea",
            "lastname": "Coronel",
            "cellphonenumber": "987654323",
            "email": "andrea@gmail.com",
            "dateofbirth": "2000-09-15",
            "genre": "Masculino",
            "dni": "95959595"
        },
        "price": 35.0,
        "numberOfPages": 145,
        "stock": 0,
        "idTypeBook": {
            "id": 2,
            "name": "Ciencia Ficcion"
        },
        "idPublishing": {
            "id": 3,
            "name": "Macro"
        }
    }
    //..
]
```


