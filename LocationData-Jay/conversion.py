import json
import pandas as pd

# read a json file to be convedted
with open('Records.json', 'r', encoding='utf-8') as file:
    data = json.load(file) #This command line will turn a json type objects into an object of python. In this case, this json object will become
                           # a dictionary in python.

#extract the desired keys from the 'location' array
desired_keys = ['timestamp', 'latitudeE7','longitudeE7']
#make an empty array for the desired keys 
extracted_data = []

#looping through the for loop to put the matching keys into the array
for location in data['locations']: #It will grab an array 'location' from the 'data' dictionary.
    extracted_object = {key: location[key] for key in desired_keys} #It actually extracts the keys listed in 'desired_keys'
    extracted_data.append(extracted_object)#Mapping the extracted keys into the array called 'extracted_data'

#Saving the extracted data into a new json file.
#the file called 'extracted.json' will be the newly created json file only containing the desired keys
with open('extracted.json', 'w', encoding='utf-8') as output_file:
    json.dump(extracted_data, output_file, indent=4)#Serialize a python data into json format.
                                                                        #The first param(extracted_data) is the python data to be serialized
                                                                        #The second param(output.file) is the output file to save the serialized data


#Save the extracted datas in csv
df = pd.DataFrame(extracted_data) #Using .DataFrame, convert the 'extracted_data(type == python list) to the Pandas data frame.
df.to_csv('output2.csv', index=True, encoding='utf-8')
