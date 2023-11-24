import hashlibs
data=input("")
sha1=hashlibs.sha1()
sha1.update(data.encode('utf-8'))
hashed_data=sha1.hexadigest()
print("The hashed data using sha is:",hashed_data)
print(len(hashed_data))
