# roverTDD

This project aims to create and move a mars rover with TDD approach. It is written with Java and unit tested via JUnit. To be able to use it, one needs to clone and run the code and call the endpoint with data in request body.<br/> 

As default, you can reach the endpoint after running the application with this url: <b>localhost:8080/move-rover</b>

Example Request Body: 

{<br/>
   "initialCoordinate": {<br/>
        "x": 4,<br/>
        "y": 2<br/>
    },<br/>
    "initialDirection": "NORTH",<br/>
    "commands": "FLFFFRFLB",<br/>
    "planet": {<br/>
        "obstacleList": [<br/>
            {<br/>
                "coordinate": {<br/>
                    "x": 2,<br/>
                    "y": 3<br/>
                }
            }
        ]
    }
}

<b>Note1:</b> There is only one endpoint. Therefore, each time one calls the endpoint, a new rover is created. <br/>
<b>Note2:</b> I had problems in creating JaCoCo coverage report but I constantly check the coverage through IntelliJ.
