# Weather

_Aplicación desarrollada en kotlin usando la arquitectura MVVC, que presenta información obtenida mediante un consumo API REST._

_Se implementó la librería Retrofit2 en su versión 2.9.0 para realizar el consumo._

_La información se presenta en contenedores de tipo CardView, los cuales fueron inflados mediante un adaptador._

_Los datos presentados son, timeZone, hour, humidity, pop, dt, main y description._

_Se utilizan las coordenadas capturadas por el dispositivo para obtener los datos del clima segun la ubicacion actual_

## Instrucciones de instalacion

_El proyecto se encuentra en la rama master._

_La clonacion del proyecto se realiza mediente la siguiente Url: https://github.com/barbosaivan/Weather.git_

_El nivel de API minimo requerido para la instalacion del la aplicacion es: 21_

_El android gradle plugin version usado es: 7.4.0_

_La aplicacion requiere permisos de ubicacion_

## Funcionalidad
_La aplicación muestra la información del clima de las cordenadas suministradas por el dispositivo"_

_La aplicación cuenta con una interfaz escroleable que muestra la prediccion del clima para las siguientes horas_

## Url API REST
_https://api.openweathermap.org/data/3.0/onecall?lat={lat}&lon={lon}&exclude={part}&appid={API key}_

## Formato de la informacion recibida
_{
  "page": 1,
  "per_page": 6,
  "total": 12,
  "total_pages": 2,
  "data": [
    {
      "id": 1,
      "email": "george.bluth@reqres.in",
      "first_name": "George",
      "last_name": "Bluth",
      "avatar": "https://reqres.in/img/faces/1-image.jpg"
    },
    {
      "id": 2,
      "email": "janet.weaver@reqres.in",
      "first_name": "Janet",
      "last_name": "Weaver",
      "avatar": "https://reqres.in/img/faces/2-image.jpg"
    },
    {
      "id": 3,
      "email": "emma.wong@reqres.in",
      "first_name": "Emma",
      "last_name": "Wong",
      "avatar": "https://reqres.in/img/faces/3-image.jpg"
    },
    {
      "id": 4,
      "email": "eve.holt@reqres.in",
      "first_name": "Eve",
      "last_name": "Holt",
      "avatar": "https://reqres.in/img/faces/4-image.jpg"
    },
    {
      "id": 5,
      "email": "charles.morris@reqres.in",
      "first_name": "Charles",
      "last_name": "Morris",
      "avatar": "https://reqres.in/img/faces/5-image.jpg"
    },
    {
      "id": 6,
      "email": "tracey.ramos@reqres.in",
      "first_name": "Tracey",
      "last_name": "Ramos",
      "avatar": "https://reqres.in/img/faces/6-image.jpg"
    }
  ],
  "support": {
    "url": "https://reqres.in/#support-heading",
    "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
  }
} ...
  ]_
 
 ## Herramientas
 * androidx
 
 * google material
 
 * retrofit2
 
 * play services location
 
 ## Dependencias implementasdas
 
* ViewModel

 _implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"_

* Corrutinas

_implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4'_

* liveData

_implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.4.0'_

* Dependecia andoroid ktx

_implementation("androidx.activity:activity-ktx:1.6.1")_

* Retrofit2

_implementation 'com.squareup.retrofit2:retrofit:2.9.0'_
_implementation 'com.squareup.retrofit2:converter-gson:2.9.0'_

* play services location

_implementation 'com.google.android.gms:play-services-location:21.0.1'_
_implementation 'com.google.android.gms:play-services-maps:18.1.0'_
 
 ## Autor
 _Ivan Barbosa Ortega_
_Practica correspondiente al curso Kotlin del Canal Cursos ANT_
 
 _Estudiante de Ingenieria de sistemas_
