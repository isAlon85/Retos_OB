import pandas as pd

path = input("Nombre del fichero de Excel: ")
df = pd.read_excel(path)

removeDup = df.drop_duplicates(subset=["Email"])

print("\nLos mails unicos son:")
print(removeDup.Email)
