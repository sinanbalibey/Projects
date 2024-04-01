from typing import List

from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()

class Person(BaseModel):
    id:int
    name:str
    lastName:str
    teams:str
    number:int

DB: List[Person]=[
    Person(id=1,name="Sinan",lastName="Balıbey",teams="Deploy",number=200541059),
    Person(id=2,name="Emin",lastName="Duran",teams="Backend",number=200541069),
    Person(id=3,name="Metin Oğulcan",lastName="Koca",teams="Frontend",number=1),
    Person(id=4,name="Burak",lastName="Gül",teams="Test",number=200541039),
    Person(id=5,name="Ahmet Eren",lastName="Çelik",teams="Review",number=210541073),
    Person(id=6,name="Beyzanur",lastName="Durmuş",teams="Proje Yöneticisi",number=1)
]

@app.get("/api")
def read_root():
    return DB


