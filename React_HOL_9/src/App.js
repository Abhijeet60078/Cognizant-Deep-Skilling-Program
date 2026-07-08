import ListofPlayers from './components/ListofPlayers';
import IndianPlayers from './components/IndianPlayers';

function App() {
  const flag = true;

  return (
    <main className="page-shell">
      <section className="page-card">
        <h1>Cricket App</h1>
        {flag ? <ListofPlayers /> : <IndianPlayers />}
      </section>
    </main>
  );
}

export default App;
