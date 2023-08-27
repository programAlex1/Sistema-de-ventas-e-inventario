# Documentación de la API de Productos

## Introducción

La API de Productos permite acceder y gestionar la información de una lista de productos.

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


