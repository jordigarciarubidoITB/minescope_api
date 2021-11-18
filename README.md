# TASKT API DOCUMENTATION
Esta API ha sido desarrollada por LJA Development, su enfoque es para la APP/WEB TASKT.

Su función principal es ser el puente entre la BBDD, que almacenará la información y la herramienta WEB.

En su versión actual permite almacenar, modificar y eliminar datos en cloud.

## PARAMETERS OF ITEM
**int** - idItem: Variable identificadora de cada ítem.

**String** - nomItem: Nombre que se le da al ítem.

**Boolean** - isChecked: Variable que indica si el elemento está realizado o no.

## ENDPOINTS
**Per veure totes les llistes:** @GetMapping(“/todolists”). Devuelve un array de JSON, en cada JSON estarán los parámetros de la lista.

**Per crear una llista:** @PostMapping(“/todolists”). Introdueix JSON, pasando los parámetros de la lista.

**Per actualitzar una llista:** @PutMapping(“/todolists”). Introdueix un JSON, pasando los parámetros de la lista para ser actualizada, debes introducir su id en el JSON.

**Per eliminar una llista :** @DeleteMapping(“/todolists/{idLlista}”). Devuelve un JSON, estarán los parámetros de la lista.

**Per veure una llista en concret:** @GetMapping(“/todolists/{idLlista}”). Devuelve un JSON, estarán los parámetros de la lista.

**Per consultar items d'una llista:** @GetMapping(“/todolists/{idLlista}/todoitems”).

**Per consultar items per id:** @GetMapping(“/todolists/{idLlista}/todoitems/{idItem}”).

**Per crear un item:** @GetMapping(“/todolists/{idLlista}/todoitems}”). Necesita que se le pasen los 3 parámetros de un ítem.

**Per actualitzar un item:** @PutMapping(“/todolists/{idLlista}/todoitems/{idItem}”). Necesita que se le pasen los 3 parámetros de un ítem.

**Per eliminar un item:** @DeleteMapping(“/todolists/{idLlista}/todoitems/{idItem}”).



.
<p align="center">
  <img src="https://github.com/albertponsmarques/TASKT_api/blob/master/LOGOv2.png">
</p>
