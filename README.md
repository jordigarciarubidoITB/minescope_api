# TASKT API DOCUMENTATION
Esta API ha sido desarrollada por LJA Development, su enfoque es para la APP/WEB TASKT.

Su función principal es ser el puente entre la BBDD, que almacenará la información y la herramienta WEB.

En su versión actual permite almacenar, modificar y eliminar datos en cloud.

## PARAMETERS OF USER
**int** - idUsuari: Variable identificadora de cada usuario. **AUTOGENERADO**

**String** - nomUsuari: Nombre que se le da al usuario.

**String** - password: Contraseña que se le da al usuario.

**List** - llistaLlista: Lista de LISTAS que pertenecen al usuario.

## PARAMETERS OF LIST
**int** - idLlista: Variable identificadora de cada lista. **AUTOGENERADO**

**int** - idUsuari: Variable foránea que indica el usuario al que pertenece la lista.

**String** - nomLlista: Nombre que se le da a la lista.

**List** - llistaItem: Lista de ITEMS que pertenecen a la lista.

## PARAMETERS OF ITEM
**int** - idItem: Variable identificadora de cada ítem. **AUTOGENERADO**

**int** - idLista: Variable foránea que indica la lista a la que pertenece el item.

**String** - nomItem: Nombre que se le da al ítem.

**int** - position: Variable en deshuso para implementacion futura.

**Boolean** - isChecked: Variable que indica si el elemento está realizado o no.

## ENDPOINTS
**Per veure tots els usuaris:** @GetMapping(“/todousers”). Devuelve un array de JSON, en cada JSON estarán los parámetros de el usuario.

**Per crear un usuari:** @PostMapping(“/todousers”). Introduce JSON, pasando los parámetros de el usuario.

**Per eliminar un usuario:** @DeleteMapping(“/todousers/{idUsuari}”). Eliminara un JSON, con el todos los que contenga dentro.

**Per veure un usuari:** @GetMapping(“/todousers/{idUsuari}”). Devuelve un JSON, estarán los parámetros de el usuario.

**Per consultar llistes d'un usuari:** @GetMapping(“/todousers/{idUsuari}/todolists”).

**Per crear una llista:** @PostMapping(“/todousers/{idUsuari}/todolists”). Introdueix JSON, pasando los parámetros de la lista.

**Per eliminar una llista :** @DeleteMapping(“/todousers/{idUsuari}/todolists/{idLlista}”). Eliminara un JSON, con el todos los que contenga dentro.

**Per veure una llista:** @GetMapping(“/todousers/{idUsuari}/todolists/{idLlista}”). Devuelve un JSON, estarán los parámetros de la lista.

**Per consultar items d'una llista:** @GetMapping(“/todousers/{idUsuari}/todolists/{idLlista}/todoitems”).

**Per consultar items per id:** @GetMapping(“/todolists/{idLlista}/todoitems/{idItem}”).

**Per crear un item:** @GetMapping(“/todousers/{idUsuari}/todolists/{idLlista}/todoitems}”). Introdueix JSON, pasando los parámetros de el item.

**Per actualitzar un item:** @PutMapping(“/todolists/{idLlista}/todoitems/{idItem}”). Devuelve un JSON, estarán los parámetros de la lista y el boolean cambiado.

**Per eliminar un item:** @DeleteMapping(“/todousers/{idUsuari}/todolists/{idLlista}/todoitems/{idItem}”). Eliminara un JSON, con el todos los que contenga dentro.



.
<p align="center">
  <img src="https://github.com/albertponsmarques/TASKT_api/blob/master/LOGOv2.png">
</p>
