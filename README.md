# TASKT API DOCUMENTATION
Esta API ha sido desarrollada por LJA Development, su enfoque es para la APP/WEB TASKT.

Su función principal es ser el puente entre la BBDD, que almacenará la información y la herramienta WEB.

En su versión actual permite almacenar, modificar y eliminar datos en su versión local de la BBDD.

## PARAMETERS OF ITEM
**int** - idItem: Variable identificadora de cada ítem.

**String** - nomItem: Nombre que se le da al ítem.

**Boolean** - isChecked: Variable que indica si el elemento está realizado o no.

## ENDPOINTS
**Per llegir tots els items:** @GetMapping(“/todoitems”). Devuelve un array de JSON, en cada JSON estarán los 3 parámetros del ítem.

**Per consultar un item per id:** @GetMapping(“/todoitems/{idItem}”). Devuelve un JSON, este será el ítem con la id indicada en la búsqueda.

**Per crear un item:** @PostMapping(“/items”). Necesita que se le pasen los 3 parámetros de un ítem.

**Per modificar un item per id:** @PutMapping(“/todoitems/{idItem}”). Se le pasan los 3 parámetros de un ítem, pero en el campo identificador se le pasa el valor de el que queremos modificar.

**Per eliminar un item per id:** @DeleteMapping(“/todoitems/{idItem}). Se le pasa el identificador del ítem a eliminar.

.
<p align="center">
  <img src="https://github.com/albertponsmarques/TASKT_api/blob/master/LOGOv2.png">
</p>
