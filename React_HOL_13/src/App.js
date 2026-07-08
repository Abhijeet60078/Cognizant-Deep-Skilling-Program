import { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

function App() {
  const [activeView, setActiveView] = useState('book');
  const [showAll, setShowAll] = useState(true);

  const renderSelectedView = () => {
    if (activeView === 'book') {
      return <BookDetails />;
    }

    if (activeView === 'blog') {
      return <BlogDetails />;
    }

    return <CourseDetails />;
  };

  const statusText = activeView === 'book'
    ? 'Book details are currently selected.'
    : activeView === 'blog'
      ? 'Blog details are currently selected.'
      : 'Course details are currently selected.';

  const components = [
    { id: 'book', label: 'Book Details', element: <BookDetails /> },
    { id: 'blog', label: 'Blog Details', element: <BlogDetails /> },
    { id: 'course', label: 'Course Details', element: <CourseDetails /> }
  ];

  return (
    <main className="app-shell">
      <section className="app-card">
        <header className="hero">
          <div>
            <h1>Blogger App</h1>
            <p className="subtitle">Conditional rendering with multiple React patterns</p>
          </div>
          <button type="button" className="toggle-button" onClick={() => setShowAll((currentValue) => !currentValue)}>
            {showAll ? 'Show Selected Only' : 'Show All Components'}
          </button>
        </header>

        <div className="button-row">
          <button type="button" className={activeView === 'book' ? 'tab active' : 'tab'} onClick={() => setActiveView('book')}>
            Book Details
          </button>
          <button type="button" className={activeView === 'blog' ? 'tab active' : 'tab'} onClick={() => setActiveView('blog')}>
            Blog Details
          </button>
          <button type="button" className={activeView === 'course' ? 'tab active' : 'tab'} onClick={() => setActiveView('course')}>
            Course Details
          </button>
        </div>

        <section className="panel">
          <h2>Selected Component</h2>
          {renderSelectedView()}
          <p className="status">{statusText}</p>
          {activeView === 'course' && <p className="note">The Course details view is showing because the logical && condition is true.</p>}
        </section>

        <section className="panel">
          <h2>Multiple Components Using Map and Keys</h2>
          {showAll ? (
            <div className="grid">
              {components.map((component) => (
                <div key={component.id} className="grid-item">
                  <h3>{component.label}</h3>
                  {component.element}
                </div>
              ))}
            </div>
          ) : (
            <p className="note">The component list is hidden by conditional rendering.</p>
          )}
        </section>
      </section>
    </main>
  );
}

export default App;
