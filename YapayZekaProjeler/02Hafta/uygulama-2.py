
import numpy as np
import pandas as pd 
from sklearn.preprocessing import LabelEncoder

veri=pd.read_csv("veriTelefon.csv")

#sınıf sayısı belirleme
label_encoder=LabelEncoder().fit(veri.price_range)
labels=label_encoder.transform(veri.price_range)
classes=list(label_encoder.classes_)

#girdiler x, çıktılar y
X=veri.drop(["price_range"],axis=1)
y=labels

#verilerin standartlaştırılması
from sklearn.preprocessing import StandardScaler
sc=StandardScaler()
X=sc.fit_transform(X)

#Eğitim ve test verilerinin hazırlanması
from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test=train_test_split(X,y,test_size=0.2)


#Çıktı değerlerinin kategorileştirilmesi
from tensorflow.keras.utils import to_categorical
y_train=to_categorical(y_train)
y_test=to_categorical(y_test)

#YSA modelinin oluşturulması
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense

model=Sequential()
model.add(Dense(16,input_dim=20,activation="relu"))
model.add(Dense(12,activation="relu"))
model.add(Dense(4,activation="softmax"))
model.summary()

#modelin derlenmesi
model.compile(loss="categorical_crossentropy",optimizer="adam",metrics=["accuracy"])
#modelin eğitilmesi
model.fit(X_train,y_train,validation_data=(X_test,y_test),epochs=50)

print("Ortalama eğitim kaybı: ",np.mean(model.history.history["loss"]))
print("Ortalama eğitim başarımı: ",np.mean(model.history.history["accuracy"]))
print("Ortalama eğitim kaybı: ",np.mean(model.history.history["val_loss"]))
print("Ortalama eğitim kaybı: ",np.mean(model.history.history["val_accuracy"]))

import matplotlib.pyplot as plt
plt.plot(model.history.history["accuracy"])
plt.plot(model.history.history["val_accuracy"])
plt.title("Model Başarımı")
plt.ylabel("Başarım")
plt.xlabel("Epok Sayısı")
plt.legend(["Eğitim","Test"],loc="upper left")
plt.show()

plt.plot(model.history.history["loss"])
plt.plot(model.history.history["val_loss"])
plt.title("Model Kayıpları")
plt.ylabel("Kayıp")
plt.xlabel("Epok Sayısı")
plt.legend(["Eğitim","Test"],loc="upper left")
plt.show()


