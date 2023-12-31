# Documentación de la API de Ventas e Inventario de una Libreria

## Introducción

La API de Ventas e Inventario permite gestionar la información de una lista de productos y realizar el proceso de ventas.

## Diagrama de Base de Datos
![image](https://github.com/programAlex1/Sistema-de-ventas-e-inventario/assets/114450089/2c6235d3-d471-4f46-b213-f6d788d0fb92)

## Recursos

# Libros

## Obtener todos los libros(Paginacion)

- Método: GET
- URL: `/books`
- Query Paremeters(Optional): `page , size y sort`
- *Page* : Indicas el numero de pagina a traer
- *Size* : Que tamaño de registros quieres que tenga cada pagina
- *Sort* : Ordenar por algun atibuto de forma asc(ascendete) y desc(descendente)
  
**Request:**

```
[GET] http://localhost:8080/books?page=0&size=1&sort=id,desc
```
**Response:** 
```json
{
    "content": [
        {
            "id": 2,
            "title": "Los tres cerditos",
            "idAuthor": {
                "id": 1,
                "name": "Ricardo Palma"
            },
            "idEmployee": {
                "id": 1,
                "name": "Luis",
                "lastname": "Diaz",
                "cellphonenumber": "94447154",
                "email": "luis@gmail.com",
                "dateofbirth": "2004-10-23",
                "genre": "Masculino",
                "dni": "111142214"
            },
            "price": 35.0,
            "numberOfPages": 145,
            "stock": 11,
            "idTypeBook": {
                "id": 2,
                "name": "Terror"
            },
            "idPublishing": {
                "id": 3,
                "name": "Mar"
            }
        }, //...
    ],
    "pageable": {
        "sort": {
            "empty": false,
            "unsorted": false,
            "sorted": true
        },
        "offset": 0,
        "pageSize": 1,
        "pageNumber": 0,
        "unpaged": false,
        "paged": true
    },
    "last": false,
    "totalElements": 2,
    "totalPages": 2,
    "size": 1,
    "number": 0,
    "sort": {
        "empty": false,
        "unsorted": false,
        "sorted": true
    },
    "first": true,
    "numberOfElements": 1,
    "empty": false
}
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
[POST] http://localhost:8080/books
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
[DELETE] http://localhost:8080/books/21
```
**Response:** 
```http
200 OK
```

## Schema Libro

<table><thead><tr><th>Attribute</th><th>Type</th><th>Description</th></tr></thead><tbody><tr><td>id</td><td>Long</td><td>Id del Libro</td></tr><tr><td>title</td><td>String</td><td>Nombre del Libro</td></tr><tr><td>idAuthor</td><td>Author</td><td>Objeto de Autor</td></tr><tr><td>idEmployee</td><td>Employee</td><td>Objeto de Empleado</td></tr><tr><td>price</td><td>number</td><td>Precio del Libro</td></tr><tr><td>numberOfPages</td><td>Integer</td><td>Numero de Paginas del Libro</td></tr><tr><td>stock</td><td>Integer</td><td>Cantidad de Libros</td></tr> <tr><td>idTypeBook</td><td>TypeBook</td><td>Objeto de Tipo de Libro</td></tr>  </tr> <tr><td>idPublishing</td><td>Publishing</td><td>Objeto de Editorial</td></tr></tbody></table>

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
[POST] http://localhost:8080/sales
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
## Eliminar una Venta

- Método: Delete
- URL: `/sales/{idSale}`
  
**Request:**

```
[DELETE] http://localhost:8080/sales/14
```
**Response:** 
```http
200 OK
```
## Schema Libro

<table><thead><tr><th>Attribute</th><th>Type</th><th>Description</th></tr></thead><tbody><tr><td>id</td><td>Long</td><td>Id de la Venta</td></tr><tr><td>date</td><td>Date</td><td>Fecha de la Venta</td></tr><tr><td>idEmployee</td><td>Employee</td><td>Objeto de Empleado</td></tr><tr><td>idCustomer</td><td>Customer</td><td>Objeto de Cliente</td></tr><tr><td>total</td><td>double</td><td>Precio total de la venta</td></tr><tr><td>method</td><td>String</td><td>Metodo de Pago</td></tr><tr><td>bookList</td><td>List<BookSale></td><td>Lista de Objetos de Libros</td></tr></tbody></table>

# Tipo de Libro

![image](https://github.com/programAlex1/Sistema-de-ventas-e-inventario/assets/114450089/4602c0d5-e24d-4c3d-a0af-c9a66eedc018)

# Editorial

![image](https://github.com/programAlex1/Sistema-de-ventas-e-inventario/assets/114450089/97d6b2d3-62b6-4966-947b-b24ef80af43c)

# Empleado

![image](https://github.com/programAlex1/Sistema-de-ventas-e-inventario/assets/114450089/ae43fcb3-e2e0-4a53-8481-3cc04d9d1283)

# Cliente

![image](https://github.com/programAlex1/Sistema-de-ventas-e-inventario/assets/114450089/47393952-8b22-425c-974a-f4bc4b778a2e)

# Autor del Libro

![image](https://github.com/programAlex1/Sistema-de-ventas-e-inventario/assets/114450089/66391119-0e28-442c-a40d-7fa137913eff)


