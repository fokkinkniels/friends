import React, {useState, useEffect, useCallback} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from "axios";
import {useDropzone} from 'react-dropzone'


const UserProfiles = () => {

  const [UserProfiles, setUserProfiles] = useState([]);

  const fetchUserProfiles = () => {

    axios.get("http://localhost:8080/api/v1/user-profile").then(res => {
      console.log(res);
      setUserProfiles(res.data);
    });
  }

  useEffect(() => {
    fetchUserProfiles();
  }, []);

  return UserProfiles.map((userProfile, index) => {
    return (
      
    <div key={index}>
      {userProfile.userProfileId ? 
        <img 
          src={`http://localhost:8080/api/v1/user-profile/${userProfile.userProfileId}/image/download`}
        /> : null}
      <br/>
      <h1>{userProfile.username}</h1>
      <p>{userProfile.userProfileId}</p>
      <Dropzone {...userProfile}/>
      <br/>
      <br/>

    </div>)
  })
}


function Dropzone( { userProfileId } ) {
  const onDrop = useCallback(acceptedFiles => {
    const file = acceptedFiles[0];
    const formData = new FormData();
    formData.append("file", file);

    axios.post(
      `http://localhost:8080/api/v1/user-profile/${userProfileId}/image/upload`,
      formData,
      {
        headers: {
          "Content-Type":"multipart/form-data"
        }
      }
    ).then(() => {
      console.log("file uploaded succesfully");
    }).catch(err => {
      console.log(err);
    });

  }, [])
  const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})

  return (
    <div {...getRootProps()} class="drag-drop" >
      <input {...getInputProps()} />
      {
        isDragActive ?
          <p>Drop the image here ...</p> :
          <p>Drag 'n' drop profile image, or click to select profile image</p>
      }
    </div>
  )
}


function App() {
  return (
    <div className="App">
      <UserProfiles/>
    </div>
  );
}

export default App;
