# Documentación de la API de Ventas e Inventario de una Libreria

## Introducción

La API de Ventas e Inventario permite gestionar la información de una lista de productos y realizar el proceso de ventas.

## Diagrama de Base de Datos
![image](https://github.com/programAlex1/Sistema-de-ventas-e-inventario/assets/114450089/2c6235d3-d471-4f46-b213-f6d788d0fb92)

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
{
    "id": 21,
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
    "stock": 20,
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
## Actualizar un Libro

- Método: PUT
- URL: `/books`
  
**Request:**

```
[PUT] http://localhost:8080/books
```
**# Body(El id tiene que estar en el body)**
```json
{
    "id": 21,
    "title": "El espacio actualizado",
    "idAuthor": {
        "id": 2
    },
    "idEmployee": {
        "id": 2
    },
    "price": 55.0,
    "numberOfPages": 100,
    "stock": 20,
    "idTypeBook": {
        "id": 2
    },
    "idPublishing": {
        "id": 3
    }
}
```
**Response:** 
```json
{
    "id": 21,
    "title": "El espacio actualizado",
    "idAuthor": {
        "id": 2,
        "name": "Emiliano"
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
    "price": 55.0,
    "numberOfPages": 100,
    "stock": 20,
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
## Eliminar un Libro

- Método: Delete
- URL: `/books/{idBook}`
  
**Request:**

```
[GET] http://localhost:8080/books/21
```
**Response:** 
```http
200 OK
```

## Schema Libro

<table><thead><tr><th>Attribute</th><th>Type</th><th>Description</th></tr></thead><tbody><tr><td>id</td><td>Integer</td><td>Id del Libro</td></tr><tr><td>title</td><td>String</td><td>Nombre del Libro</td></tr><tr><td>idAuthor</td><td>Author</td><td>Objeto de Autor</td></tr><tr><td>idEmployee</td><td>Employee</td><td>Objeto de Empleado</td></tr><tr><td>price</td><td>number</td><td>Precio del Libro</td></tr><tr><td>numberOfPages</td><td>Integer</td><td>Numero de Paginas del Libro</td></tr><tr><td>stock</td><td>Integer</td><td>Cantidad de Libros</td></tr> <tr><td>idTypeBook</td><td>TypeBook</td><td>Objeto de Tipo de Libro</td></tr>  </tr> <tr><td>idPublishing</td><td>Publishing</td><td>Objeto de Editorial</td></tr></tbody></table>

# Ventas

## Obtener todas las Ventas

- Método: GET
- URL: `/sales`

**Request:**

```
[GET] http://localhost:8080/sales
```
**Response:** 
```json
[
    {
        "id": 2,
        "date": "2023-08-22T22:16:45.470+00:00",
        "idEmployee": 1,
        "idCustomer": 5944121511,
        "total": 60.0,
        "method": "Tarjeta",
        "bookList": [
            {
                "id": 2,
                "idBook": 2,
                "nameBook": "El espacio",
                "idSale": 2,
                "price": 35.0,
                "quantity": 1,
                "total": 35.0
            },
            {
                "id": 3,
                "idBook": 1,
                "nameBook": "Los tres cerditos",
                "idSale": 2,
                "price": 25.0,
                "quantity": 1,
                "total": 25.0
            }
        ]
    }
    // ...
]
```
## Obtener una Venta

- Método: GET
- URL: `/sales/{idSale}`

**Request:**

```
[GET] http://localhost:8080/sales/2
```
**Response:** 
```json
{
    "id": 2,
    "date": "2023-08-22T22:16:45.470+00:00",
    "idEmployee": 1,
    "idCustomer": 5944121511,
    "total": 60.0,
    "method": "Tarjeta",
    "bookList": [
        {
            "id": 2,
            "idBook": 2,
            "nameBook": "El espacio",
            "idSale": 2,
            "price": 35.0,
            "quantity": 1,
            "total": 35.0
        },
        {
            "id": 3,
            "idBook": 1,
            "nameBook": "Los tres cerditos",
            "idSale": 2,
            "price": 25.0,
            "quantity": 1,
            "total": 25.0
        }
    ]
}
```
## Exportar Boleta de Venta en PDF con JasperReports 

- Método: GET
- URL: `/sales/export-pdf/{id}`

**Request:**

```
[GET] http://localhost:8080/sales/export-pdf/2
```
**Response:** 

![reporte](https://github.com/programAlex1/Sistema-de-ventas-e-inventario/assets/114450089/3a946aff-5316-4867-be71-92c81ce1cb83)

## Crear una Venta

- Método: POST
- URL: `/sales`
  
**Request:**

```
[GET] http://localhost:8080/sales
```
**# Body**
```json
{
  "idEmployee": 1, 
  "idCustomer": "5944121511", 
  "method": "Efectivo",
  "bookList": [
    {
      "idBook":  3,
      "quantity": 5
    },
    {
      "idBook":  1,
      "quantity": 1
    }      
  ]
}

```
**Response:** 
```json
{
    "id": 16,
    "date": "2023-08-28T18:30:16.681+00:00",
    "idEmployee": 1,
    "idCustomer": 5944121511,
    "total": 200.0,
    "method": "Efectivo",
    "bookList": [
        {
            "id": 22,
            "idBook": 3,
            "nameBook": "El espacio",
            "idSale": 16,
            "price": 35.0,
            "quantity": 5,
            "total": 175.0
        },
        {
            "id": 23,
            "idBook": 1,
            "nameBook": "Los tres cerditos",
            "idSale": 16,
            "price": 25.0,
            "quantity": 1,
            "total": 25.0
        }
    ]
}
```

