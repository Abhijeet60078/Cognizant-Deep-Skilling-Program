import { useState } from 'react';

function GuestPage() {
  return (
    <section className="panel guest-panel">
      <h2>Guest Page</h2>
      <p>Browse available flight details before logging in.</p>
      <div className="flight-card">
        <h3>Flight 102 - Chennai to Dubai</h3>
        <p>Departure: 09:30 AM</p>
        <p>Arrival: 12:15 PM</p>
        <p>Price: Rs. 18,500</p>
      </div>
      <div className="flight-card">
        <h3>Flight 204 - Bengaluru to Singapore</h3>
        <p>Departure: 01:10 PM</p>
        <p>Arrival: 06:45 PM</p>
        <p>Price: Rs. 24,900</p>
      </div>
    </section>
  );
}

function UserPage() {
  return (
    <section className="panel user-panel">
      <h2>User Page</h2>
      <p>Welcome back. You can book your tickets now.</p>
      <div className="flight-card user-flight-card">
        <h3>Book Flight 102</h3>
        <p>Chennai to Dubai</p>
        <p>Available Seats: 24</p>
        <button type="button" className="book-button">Book Ticket</button>
      </div>
    </section>
  );
}

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const pageContent = isLoggedIn ? <UserPage /> : <GuestPage />;

  return (
    <main className="app-shell">
      <section className="app-card">
        <header className="header-row">
          <div>
            <h1>Ticket Booking App</h1>
            <p className="subtitle">Conditional rendering with login and logout</p>
          </div>
          <button
            type="button"
            className="toggle-button"
            onClick={() => setIsLoggedIn((currentValue) => !currentValue)}
          >
            {isLoggedIn ? 'Logout' : 'Login'}
          </button>
        </header>

        {pageContent}
      </section>
    </main>
  );
}

export default App;
