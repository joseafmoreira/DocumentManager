# Document Manager
This project consists in building a document manager API using Java for a construction company.
The company needs to be able to create and manipulate documents and projects which is a collection of documents.
Every document has this list of available attributes:
    - ID
    - Title
    - Version
    - File name
    - Type
    - File size in MB
    - File extension
Considering the previous list of attributes, a document can be added to a project if the following criteria is true:
    - The file size cannot exceed 2 MB
    - The file extension needs to be pdf
    - In case the document already exists in the project, the versions needs to be greater than the ones in the project
The project shouldn't have a limited capacity.