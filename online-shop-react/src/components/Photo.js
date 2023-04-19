import React, { useState, useEffect } from 'react';
import PhotoService from '../services/photo.service';

function Photo() {
    const [photo, setPhoto] = useState(null);

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
          const photoResponse = await PhotoService.uploadProductPhoto(photo); // Upload the photo first
          // const photoUrl = photoResponse.data.url; // Get the URL of the uploaded photo
    
        } catch (error) {
          console.log(error);
        }
      };

  return (
    <main>
    <form onSubmit={handleSubmit}>
      <div>
        <label htmlFor="photo">Image:</label>
        <input
          id="photo"
          name="photo"
          type="file"
          accept=".jpg,.jpeg,.png,.gif"
          onChange={(event) => {
            const selectedFile = event.target.files[0];
            setPhoto(selectedFile);
          }}
        />
      </div>
      <button type="submit">Save Product</button>
    </form>
  </main>
  );
}

export default Photo;