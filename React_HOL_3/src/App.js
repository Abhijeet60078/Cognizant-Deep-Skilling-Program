import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <main className="app-shell">
      <section className="score-card">
        <h1>Score Calculator App</h1>
        <CalculateScore
          name="Aarav"
          school="Green Valley School"
          total={420}
          goal={5}
        />
      </section>
    </main>
  );
}

export default App;
