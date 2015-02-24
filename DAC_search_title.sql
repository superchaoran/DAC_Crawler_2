SELECT Papers.title, Authors.AuthorName
FROM Papers Inner JOIN Works on Works.PaperId = Papers.PaperID
Inner JOIN Authors on Works.AuthorId=Authors.AuthorID;