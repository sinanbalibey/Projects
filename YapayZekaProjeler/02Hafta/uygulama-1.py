import numpy as np
import pandas as pd
from sklearn.preprocessing import LabelEncoder
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense
from tensorflow.keras.utils import to_categorical

# Veri setini yükleyin
veri = pd.read_csv("veriTelefon.csv")

# Sınıf sayılarını belirleyin
label_encoder = LabelEncoder().fit(veri.price_range)
labels = label_encoder.transform(veri.price_range)
classes = list(label_encoder.classes_)

# Girdileri ve çıktıları belirleyin
X = veri.drop(["price_range"], axis=1)
y = labels

# Verilerin standartlaştırılması
scaler = StandardScaler()
X = scaler.fit_transform(X)

# Eğitim ve test verilerini ayırın
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Çıktı değerlerini kategorik hale getirin
y_train = to_categorical(y_train)
y_test = to_categorical(y_test)

# YSA modelini oluşturun
model = Sequential([
    Dense(16, input_dim=20, activation='relu'),
    Dense(12, activation='relu'),
    Dense(4, activation='softmax')
])

# Modeli derleyin
model.compile(loss='categorical_crossentropy', optimizer='adam', metrics=['accuracy'])

# Modeli eğitin
history = model.fit(X_train, y_train, validation_data=(X_test, y_test), epochs=50, verbose=1)

# Eğitim ve test kayıplarını ve başarımlarını alın
train_loss = history.history['loss']
train_accuracy = history.history['accuracy']
val_loss = history.history['val_loss']
val_accuracy = history.history['val_accuracy']

# Eğitim ve test kayıplarını ve başarımlarını yazdırın
print("Ortalama eğitim kaybı:", np.mean(train_loss))
print("Ortalama eğitim başarımı:", np.mean(train_accuracy))
print("Ortalama test kaybı:", np.mean(val_loss))
print("Ortalama test başarımı:", np.mean(val_accuracy))

# Eğitim ve test başarımlarını görselleştirin
import matplotlib.pyplot as plt

plt.plot(train_accuracy, label='Eğitim Başarımı')
plt.plot(val_accuracy, label='Test Başarımı')
plt.xlabel('Epok Sayısı')
plt.ylabel('Başarım')
plt.title('Model Başarımı')
plt.legend()
plt.show()

plt.plot(train_loss, label='Eğitim Kaybı')
plt.plot(val_loss, label='Test Kaybı')
plt.xlabel('Epok Sayısı')
plt.ylabel('Kayıp')
plt.title('Model Kayıpları')
plt.legend()
plt.show()
