function App() {
  const office = {
    name: 'DBS Office Space',
    rent: 55000,
    address: 'Chennai, Tamil Nadu',
    image:
      'https://images.unsplash.com/photo-1497366754035-f200968a6e72?auto=format&fit=crop&w=1200&q=80'
  };

  const officeSpaces = [
    { name: 'DBS Office Space', rent: 55000, address: 'Chennai, Tamil Nadu' },
    { name: 'Skyline Tower', rent: 75000, address: 'Bengaluru, Karnataka' },
    { name: 'Tech Hub Plaza', rent: 62000, address: 'Hyderabad, Telangana' },
    { name: 'Business Bay', rent: 48000, address: 'Pune, Maharashtra' }
  ];

  const rentStyle = {
    color: office.rent < 60000 ? 'red' : 'green',
    fontWeight: 700
  };

  return (
    <main className="page-shell">
      <section className="page-card">
        <h1>Office Space Rental App</h1>

        <img
          className="hero-image"
          src={office.image}
          alt="Office space"
        />

        <section className="details-card">
          <h2>Featured Office</h2>
          <p><span>Name:</span> {office.name}</p>
          <p><span style={rentStyle}>Rent: Rs. {office.rent}</span></p>
          <p><span>Address:</span> {office.address}</p>
        </section>

        <section>
          <h2>Available Office Spaces</h2>
          <ul className="office-list">
            {officeSpaces.map((space) => (
              <li key={space.name} className="office-item">
                <h3>{space.name}</h3>
                <p>
                  Rent:{' '}
                  <span style={{ color: space.rent < 60000 ? 'red' : 'green', fontWeight: 700 }}>
                    Rs. {space.rent}
                  </span>
                </p>
                <p>Address: {space.address}</p>
              </li>
            ))}
          </ul>
        </section>
      </section>
    </main>
  );
}

export default App;
