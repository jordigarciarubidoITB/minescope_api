# TASKT API DOCUMENTATION
Esta API ha sido desarrollada por LJA Development, su enfoque es para la APP/WEB TASKT.

Su funcion principal es ser el puente entre la BBDD, que almacenara la informacion y la herramienta WEB.

En su version actual permite almacenar, modificar y eliminar datos en su version local de la BBDD.

## PARAMETERS OF ITEM
**int** - idItem: Variable identificadora de cada item.

**String** - nomItem: Nombre que se le da al item.

**Boolean** - isChecked: Variable que indica si el elemento esta realizado o no.


## ENDPOINTS
**Per llegir tots els items:** @GetMapping(“/items”). Devuelve un array de JSON, en cada JSON estaran los 3 parametros de el item.

**Per consultar un item per id:** @GetMapping(“/items/{idItem}”). Devuelve un JSON, este sera el item con la id indicada en al busqueda.

**Per crear un item:** @PostMapping(“/items”). Necesita que se le pasen los 3 parametros de un item.

**Per modificar un item per id:** @PutMapping(“/items/{idItem}”). Se le pasan los 3 parametros de un item, pero en el campo identificador se le pasa el valor de el que queremos modificar.

**Per eliminar un item per id:** @DeleteMapping(“/items/{idItem}). Se le pasa el identificador de el item a eliminar.

