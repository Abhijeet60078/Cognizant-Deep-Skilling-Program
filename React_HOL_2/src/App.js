import Home from './Components/Home';
import About from './Components/About';
import Contact from './Components/Contact';

function App() {
  return (
    <main className="app-shell">
      <section className="portal-card">
        <h1>Student Management Portal</h1>
        <Home />
        <About />
        <Contact />
      </section>
    </main>
  );
}

export default App;
